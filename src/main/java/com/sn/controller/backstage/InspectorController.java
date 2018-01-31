package com.sn.controller.backstage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.sn.common.FileUpload;
import com.sn.common.Plupload;
import com.sn.common.PluploadUtil;
import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.Inspector;
import com.sn.entity.Organize;
import com.sn.service.InspectorService;
import com.sn.service.OrganizeService;
import com.sn.type.Result;
import com.sn.util.PagedResult;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/backstage/inspector")
public class InspectorController {

	@Autowired
	private InspectorService inspectorService;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	private static String fileURL = "/material/";

	private String fileName = "";

	private ComData com;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("show")
	public String show(Map<String, Object> model) {
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "/backstage/inspector/show.html"); 
		Organize organize = new Organize(); 
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll", oragenizeAll.getDataList());
		model.put("active", "inspector");
		model.put("com", com);
		return "/backstage/inspector";
	}
	
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("showType")
	public String showType(Map<String, Object> model) {
		Organize organize = new Organize(); 
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll", oragenizeAll.getDataList());
		model.put("active", "inspector");
		model.put("com", com);
		return "/backstage/inspectorType";
	}

	/**
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param model
	 * @return
	 */
	@RequestMapping("getDataType")
	@ResponseBody
	public Map<String, Object> getDataType(Integer draw,String type, Map<String, Object> model) {
		// 每页返回的条数
		String departmentid = (String) request.getSession().getAttribute("departmentid");
		String roleid = (String) request.getSession().getAttribute("roleid");
		int pageSize = 10;
		String length = request.getParameter("length");
		if (!StringUtils.isEmpty(length)) {
			pageSize = Integer.parseInt(length);
		}
		int start = Integer.parseInt(request.getParameter("start"));
		int indexPage = start / pageSize + 1;
		Map<String, String[]> params = request.getParameterMap();
		String[] sort = params.get("order[0][column]");
		String[] desc = params.get("order[0][dir]");
		String[] value = params.get("search[value]");

		String orderByStr = null;
		switch (sort[0]) {
		case "8":
			orderByStr = " twice asc,createdate";
			break;
		case "2":
			orderByStr = " twice asc,department";
			break;
		case "1":
			orderByStr = " twice asc,qdepartment";
			break;
		case "3":
			orderByStr = " twice asc,paddress";
			break;
		case "4":
			orderByStr = " twice asc,ptime";
			break;
		case "6":
			orderByStr = " twice asc,twice";
			break;
		case "7":
			orderByStr = " twice asc,entryper";
			break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Inspector inspector = new Inspector();
		inspector.setDescription(type);
		//解析高级搜索
		try {
			if(value != null && value[0].length() > 0) { 
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ---------数据权限
		if(!departmentid.equals("sdfa")&&!departmentid.equals("cd384f7c041a4652b901fa9cd31cdb94")){
			Organize o = organizeService.findById(departmentid);
			String parendid = o.getParentid();
			inspector.setQdepartmentid(parendid);
		}
		
		/*
		 * String
		 * id=CompetenceManager.getScope("/backstage/inspector/show.html",
		 * roleid); if(id.length()>0){ inspector.setAnnex(id); }
		 */
		// ----------
		PagedResult<Inspector> page_list = inspectorService.findByPageCustom(inspector, indexPage, pageSize, orderByStr);
		List<Inspector> i_list=page_list.getDataList();
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		for(Inspector i:i_list){ 
			if(i.getDescription2()!=null&&!i.getDescription2().equals("-1")&&i.getQtype()!=null&&i.getQtype().equals("1")){
				i.setDescription(DatadictionaryMap.get(i.getDescription())+","+DatadictionaryMap.get(i.getDescription2()));
			}else{ 
				i.setDescription(DatadictionaryMap.get(i.getDescription()));
			}
			
		}
		model.put("recordsTotal", page_list.getTotal());
		model.put("recordsFiltered", page_list.getTotal());
		model.put("draw", draw);
		model.put("data", i_list);
		return model;
	}
	/**
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param model
	 * @return
	 */
	@RequestMapping("getDate")
	@ResponseBody
	public Map<String, Object> getDate(Integer draw, Map<String, Object> model) {
		// 每页返回的条数
		String departmentid = (String) request.getSession().getAttribute("departmentid");
		String roleid = (String) request.getSession().getAttribute("roleid");
		int pageSize = 10;
		String length = request.getParameter("length");
		if (!StringUtils.isEmpty(length)) {
			pageSize = Integer.parseInt(length);
		}
		int start = Integer.parseInt(request.getParameter("start"));
		int indexPage = start / pageSize + 1;
		Map<String, String[]> params = request.getParameterMap();
		String[] sort = params.get("order[0][column]");
		String[] desc = params.get("order[0][dir]");
		String[] value = params.get("search[value]");

		String orderByStr = null;
		switch (sort[0]) {
		case "8":
			orderByStr = " twice asc,createdate";
			break;
		case "2":
			orderByStr = " twice asc,department";
			break;
		case "1":
			orderByStr = " twice asc,qdepartment";
			break;
		case "3":
			orderByStr = " twice asc,paddress";
			break;
		case "4":
			orderByStr = " twice asc,ptime";
			break;
		case "6":
			orderByStr = " twice asc,twice";
			break;
		case "7":
			orderByStr = " twice asc,entryper";
			break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Inspector inspector = new Inspector();
		//解析高级搜索
		try {
			if(value != null && value[0].length() > 0) {
				String[] data=value[0].split(",");
				if(data[0]!=null&&!data[0].equals("0")){
					inspector.setQdepartmentid(data[0]);
				}
				if(!data[1].equals("2")){
					inspector.setQtype(data[1]);
				}
				if(!data[2].equals("2")){
					inspector.setTwice(Double.parseDouble(data[2]));
				}
				if(!data[3].equals("-1")){
					inspector.setDescription(data[3]);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if(data[4]!=null&&data[4].trim().length()>0){
					inspector.setPtime(dateFormat.parse(data[4].trim()));
				}
				if(data[5]!=null&&data[5].trim().length()>0){
					Date edate=dateFormat.parse(data[5].trim());
					Calendar date = Calendar.getInstance();
					date.setTime(edate);
					date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
					inspector.setModifydate(date.getTime());
				}  
				if(data[6]!=null&&!data[6].trim().equals("0")&&!data[6].trim().equals("undefined")){
					inspector.setDepartmentid(data[6]);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ---------数据权限
		if(!departmentid.equals("sdfa")&&!departmentid.equals("cd384f7c041a4652b901fa9cd31cdb94")){
			Organize o = organizeService.findById(departmentid);
			String parendid = o.getParentid();
			inspector.setQdepartmentid(parendid);
		}
		
		/*
		 * String
		 * id=CompetenceManager.getScope("/backstage/inspector/show.html",
		 * roleid); if(id.length()>0){ inspector.setAnnex(id); }
		 */
		// ----------
		PagedResult<Inspector> page_list = inspectorService.findByPageCustom(inspector, indexPage, pageSize, orderByStr);
		List<Inspector> i_list=page_list.getDataList();
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		for(Inspector i:i_list){ 
			if(i.getDescription2()!=null&&!i.getDescription2().equals("-1")&&i.getQtype()!=null&&i.getQtype().equals("1")){
				i.setDescription(DatadictionaryMap.get(i.getDescription())+","+DatadictionaryMap.get(i.getDescription2()));
			}else{ 
				i.setDescription(DatadictionaryMap.get(i.getDescription()));
			}
			
		}
		model.put("recordsTotal", page_list.getTotal());
		model.put("recordsFiltered", page_list.getTotal());
		model.put("draw", draw);
		model.put("data", i_list);
		return model;
	}

	/**
	 * @see 获得编辑数据
	 * @author xiao
	 * @throws IOException
	 */
	@RequestMapping("getEditData")
	@ResponseBody
	public Result getEditData(String fuid, Map<String, Object> model) throws IOException {
		Result result = new Result();
		Inspector inspector = inspectorService.findById(fuid);
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		inspector.setEntryid(DatadictionaryMap.get(inspector.getDescription()));
		inspector.setPresult(DatadictionaryMap.get(inspector.getPresult()));
		model.put("inspector", inspector);
		result.setData(model);
		return result;
	}

	/**
	 * @see 处理结果
	 * @author xiao
	 * @throws IOException
	 */
	@RequestMapping("process")
	@ResponseBody
	public Result process(Inspector inspector, Map<String, Object> model){
		Result result = new Result();
		inspector.setTwice(1.0);
		  inspectorService.updateSelective(inspector);
		  return result;
	} 
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param inspector
	 *            实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Inspector inspector, Map<String, Object> model) throws IOException {
		Result result = new Result();
		String id = inspector.getFuid();
		if (id != null && id.length() > 0) {
			inspectorService.updateSelective(inspector);
		} else {
			inspector.setFuid(UUIDCreater.getUUID());
			inspector.setCreatedate(new Timestamp(new Date().getTime()));
			inspector.setTwice(0.0);
			inspector.setEntryid((String) request.getSession().getAttribute("userid"));
			inspector.setEntryper((String) request.getSession().getAttribute("username"));
			inspector.setModifydate(new Date());
			inspectorService.insertSelective(inspector);
		}
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", inspector.getFuid());
		result.setData(m);
		return result;
	}

	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param id
	 *            主键
	 * @param model
	 * @return 列表显示页
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String fuid) {
		Result result = new Result();
		if (fuid != null && fuid.length() > 0) {
			inspectorService.deleteById(fuid);
		}
		return result;
	}

	/**
	 * @see ajax查询组织
	 * @author xiao
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("getOrChild")
	@ResponseBody
	public String getOrChild(String parentid) throws IOException {
		PrintWriter out = response.getWriter();
		Organize organize = new Organize();
		organize.setLayer(3);
		organize.setParentid(parentid);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		out.print(JSONArray.toJSON(oragenizeAll.getDataList()));
		return null;
	}

	/**
	 * @see 上传文件
	 * @author xiao
	 * @throws IOException
	 */
	@RequestMapping("upload")
	@ResponseBody
	public String upload(Plupload plupload, @RequestParam("file") MultipartFile file, String fuid) throws IOException {
		PrintWriter out = response.getWriter();
		plupload.setRequest(request);
		plupload.setFormerly(file.getOriginalFilename());
		plupload.setMultipartFile(file);
		// 文件存储路径
		File dir = new File(request.getSession().getServletContext().getRealPath("/") + fileURL);
		try {
			// 上传文件
			String filename = PluploadUtil.upload(plupload, dir);
			// 判断文件是否上传成功（被分成块的文件是否全部上传完成）
			if (PluploadUtil.isUploadFinish(plupload)) {
				// 插入数据
				// String url =
				// request.getSession().getServletContext().getRealPath("/") +
				// fileURL + filename;
				fileName += filename + ",";
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(1);
		return null;
	}

	/**
	 * @see 导入word
	 * @author xiao
	 * @throws IOException
	 */
	@RequestMapping("wordIn")
	public String wordIn(@RequestParam(value = "wordfile") MultipartFile[] wordfile, Map<String, Object> model) throws IOException {
		FileInputStream in = null;
		POIFSFileSystem pfs = null;
		List<String> list = new ArrayList<String>();
		if (wordfile != null && !wordfile[0].isEmpty()) {
			ArrayList<String> file_list = FileUpload.uploadFile(wordfile, request, false);
			String path = request.getSession().getServletContext().getRealPath("/") + FileUpload.FILE_PATH + file_list.get(0);

			in = new FileInputStream(path);// 载入文档
			try {
				pfs = new POIFSFileSystem(in);
				HWPFDocument hwpf = new HWPFDocument(pfs);
				Range range = hwpf.getRange();// 得到文档的读取范围
				TableIterator it = new TableIterator(range);

				// 迭代文档中的表格
				if (it.hasNext()) {
					TableRow tr = null;
					TableCell td = null;
					Paragraph para = null;
					String lineString;
					String cellString;
					Table tb = (Table) it.next();
					// 迭代行，从第2行开始
					for (int i = 2; i < tb.numRows(); i++) {
						tr = tb.getRow(i);
						lineString = "";
						for (int j = 0; j < tr.numCells(); j++) {
							td = tr.getCell(j);// 取得单元格
							// 取得单元格的内容
							for (int k = 0; k < td.numParagraphs(); k++) {
								para = td.getParagraph(k);
								cellString = para.text();

								if (cellString != null && cellString.compareTo("") != 0) {
									// 如果不trim，取出的内容后会有一个乱码字符
									cellString = cellString.trim();
									if (cellString.length() > 0) {
										cellString += "~";
									}
								}

								lineString += cellString;
							}
						}
						// 去除字符串末尾的一个管道符
						if (lineString != null && lineString.compareTo("") != 0) {
							lineString = lineString.substring(0, lineString.length() - 1);
						}
						if (lineString.length() > 0) {
							list.add(lineString);
						}
					}
				}

				if (list.size() > 0) {
					for (int a = 0; a < list.size(); a++) {
						String tt = list.get(a);
						String data[] = tt.split("~");
						if (data.length == 6) {
							Inspector inspector = new Inspector();
							inspector.setFuid(UUIDCreater.getUUID());
							// 解析县公安局
							String department = data[0];
							Organize organize = new Organize();
							organize.setFullname(department);
							List<Organize> olist = organizeService.selectByColum(organize, null);
							if (olist != null && olist.size() > 0) {
								inspector.setQdepartment(department);
								inspector.setQdepartmentid(olist.get(0).getFuid());
							}
							// 解析部门
							String qdepartment = data[1];
							Organize o = new Organize();
							o.setFullname(qdepartment);
							List<Organize> qolist = organizeService.selectLikeColum(o);
							if (qolist != null && qolist.size() > 0) {
								inspector.setDepartment(qdepartment);
								inspector.setDepartmentid(qolist.get(0).getFuid());
							}
							inspector.setPaddress(data[2]);
							// 处理时间
							try {
								String time = data[3];
								String date = data[5];
								String t1[] = time.split("-");
								time = t1[0];
								time = time.replace("：", ":");
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
								String ti = "2016年" + date + " " + time;
								inspector.setPtime(formatter.parse(ti));
							} catch (Exception e) {
								// TODO: handle exception
							}
							inspector.setDescription(data[4]);
							inspector.setCreatedate(new Date());
							inspector.setModifydate(new Date());
							inspectorService.insert(inspector);
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != in) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return "redirect:/backstage/inspector/show.html";

		}
		return "redirect:/backstage/inspector/show.html";
	}

	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param id
	 *            主键
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("saveImg")
	@ResponseBody
	public Result saveImg(String fuid) throws IOException {
		PrintWriter out = response.getWriter();
		if (fileName.length() > 0) {
			fileName = fileName.substring(0, fileName.length() - 1);
			Inspector inspector = new Inspector();
			inspector.setFuid(fuid);
			inspector.setModifydate(new Date());
			inspector.setAnnex(fileName);
			inspectorService.updateSelective(inspector);
		}
		fileName = "";
		out.print(1);
		return null;
	}

	/**
	 * @see 显示列表页
	 * @param model
	 * @return
	 */
	@RequestMapping("showDj")
	public String show(String type,Map<String, Object> model) {
		model.put("type", type);
		return "/system/500";
	}
	
	
	@RequestMapping("ShowNodata")
	public String ShowNodata(String type,Map<String, Object> model) {
		model.put("type", type);
		return "/system/nodata";
	}
}
