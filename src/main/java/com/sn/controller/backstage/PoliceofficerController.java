package com.sn.controller.backstage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.sn.common.ExcelHelper;
import com.sn.common.FileUpload;
import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.entity.Organize;
import com.sn.entity.Policeofficer;
import com.sn.entity.Risk;
import com.sn.service.OrganizeService;
import com.sn.service.PoliceofficerService;
import com.sn.service.RiskService;
import com.sn.type.Result;
import com.sn.util.PagedResult;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/backstage/policeofficer")
public class PoliceofficerController {

	@Autowired
	private PoliceofficerService policeofficerService;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private RiskService riskService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	private ComData com;

	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("show")
	public String show(Map<String, Object> model) {
		Organize organize=new Organize();
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll",oragenizeAll.getDataList());
		model.put("active", "policeofficer");
		return "/backstage/policeofficer";
	}

	/**
	 * @see 显示风险排查
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("showFX")
	public String showFX(Map<String, Object> model) {
		Organize organize=new Organize();
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll",oragenizeAll.getDataList());
		model.put("active", "policerisk");
		return "/backstage/policerisk";
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
		case "1":
			orderByStr = " name";
			break;
		case "2":
			orderByStr = " duties";
			break;
		case "3":
			orderByStr = " outside";
			break;
		case "6":
			orderByStr = " unit";
			break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Policeofficer policeofficer = new Policeofficer();
		if (value != null && value[0].length() > 0) {
			policeofficer.setName(value[0]);
			policeofficer.setPolicenum(value[0]);
			policeofficer.setIphone(value[0]);
		}
		PagedResult<Policeofficer> page_list = policeofficerService.findByPageCustom(policeofficer, indexPage, pageSize, orderByStr);
		model.put("recordsTotal", page_list.getTotal());
		model.put("recordsFiltered", page_list.getTotal());
		model.put("draw", draw);
		model.put("data", page_list.getDataList());
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
		Policeofficer policeofficer = policeofficerService.findById(fuid);
		model.put("policeofficer", policeofficer);
		result.setData(model);
		return result;
	}

	/**
	 * @see 自动提示警员
	 * @author xiao
	 */
	@RequestMapping("autoData") 
	@ResponseBody
	public String autoData(String term,Map<String,Object> model) throws IOException{
		PrintWriter out=response.getWriter();
		Policeofficer policeofficer=new Policeofficer();
		policeofficer.setName(term); 
		if(term!=null&&term.length()>0){
			PagedResult<Policeofficer> plist=policeofficerService.findByPageCustom(policeofficer, 1, 10, "name");
			List <Policeofficer> list=plist.getDataList();
			List<Policeofficer> _list=new ArrayList<Policeofficer>();
			if(list!=null&&list.size()>0){ 
				for(Policeofficer tt :list){
					Policeofficer p=new Policeofficer();
					p.setText(tt.getName()); 
					p.setId(tt.getFuid()); 
					_list.add(p);
				} 
				out.print( JSONArray.toJSON(_list));
			}
		} 
		return null;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param policeofficer
	 *            实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Policeofficer policeofficer, Map<String, Object> model) throws IOException {
		Result result = new Result();
		String id = policeofficer.getFuid();
		if (id != null && id.length() > 0) {
			policeofficerService.updateSelective(policeofficer);
		} else {
			policeofficer.setFuid(UUIDCreater.getUUID());
			policeofficer.setCreatedate(new Date());
			policeofficerService.insertSelective(policeofficer);
		}
		return result;
	}
	
	
	/**
	 * @see
	 * @param policeofficer
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("savePC")
	@ResponseBody
	public String savePC(Risk risk, Map<String, Object> model) throws IOException {
		PrintWriter out= response.getWriter();
		String fuid=risk.getFuid();
		if(fuid!=null&&fuid.length()>0){
			risk.setModifydate(new Date());
			riskService.updateSelective(risk);
		}else{
			risk.setFuid(UUIDCreater.getUUID());
			risk.setCreatedate(new Date());
			risk.setModifydate(new Date());
			riskService.insertSelective(risk);
		}
		out.print("");
		return null;
	}
	
	/**
	 * @see
	 * @param policeofficer
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("RiskPc")
	@ResponseBody
	public String RiskPc(String fuid, Map<String, Object> model) throws IOException {
		PrintWriter out= response.getWriter();
		Risk risk=new Risk();
		risk.setPerid(fuid);
		List<Risk> r_list=riskService.selectByColum(risk, null);
		if(r_list!=null&&r_list.size()>0){
			out.print(JSONArray.toJSON(r_list.get(0)));
		}else{
			Policeofficer policeofficer=policeofficerService.findById(fuid);
			policeofficer.setPerid(fuid);
			policeofficer.setFuid(null);
			out.print(JSONArray.toJSON(policeofficer));
		}
		return null;
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
			policeofficerService.deleteById(fuid);
		}
		return result;
	}

	/**
	 * @see 显示数据导入页
	 * @author xiao
	 * @param model
	 * @return 
	 */
	@RequestMapping("showImport")
	public String showImport(Map<String, Object> model,String re) {
		Organize organize=new Organize();
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll",oragenizeAll.getDataList());
		model.put("active", "policeofficer");  
		model.put("re", re);
		return "/backstage/policeofficerImport";
	}

	/**
	 * @see 数据导入
	 * @author xiao
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("EImport")
	public String EImport(@RequestParam(value = "exfile") MultipartFile[] exfile,String organizeId, Map<String, Object> model) throws IOException {
		if (exfile != null && !exfile[0].isEmpty()) {
			ArrayList<String> file_list = FileUpload.uploadFile(exfile, request, false);
			if (file_list != null && file_list.size() > 0) {
				String path = request.getSession().getServletContext().getRealPath("/") + FileUpload.FILE_PATH + file_list.get(0);
				// 查询原始数据
				List<Policeofficer> AllData = policeofficerService.selectAll(null);
				Organize _organize=new Organize();
				_organize.setParentid(organizeId);
				List<Organize> oragenizeAll = organizeService.selectByColum(_organize, null);
				// 解析EXCEL
				List<String> list = null;
				try {
					list = ExcelHelper.exportListFromExcel(new File(path), 0);
					if (list != null && list.size() > 0) {
						for (int a=1;a<list.size();a++) {
							String ll =list.get(a);
							String data[] = ll.split("\\|");
							Policeofficer policeofficer = new Policeofficer();
							// 判断原始数据是否存在
							String uid = IsExistPolice(AllData, data[1]);
							policeofficer.setPolicenum(data[1]);
							policeofficer.setName(data[2]);
							policeofficer.setInside(data[3]);
							policeofficer.setDuties(data[4]);
							policeofficer.setOutside(data[5]);
							policeofficer.setCornet(data[6]);
							policeofficer.setEmail(data[7]);
							policeofficer.setIphone(data[8]);
							policeofficer.setRoomnumber(data[9]);
							policeofficer.setFax(data[10]);
							policeofficer.setUnit(data[11]);
							policeofficer.setCreatedate(new Date());
							policeofficer.setModifydate(new Date());
							policeofficer.setIdcard(data[12]);
							// 判断组织
							String orgId = IsExistOragenize(oragenizeAll, data[11]);
							if (orgId != null ) {
								policeofficer.setUnitid(orgId);
								// 组织不存在创建组织
							} else {
								Organize organize = new Organize();
								organize.setFullname(data[11]);
								organize.setFuid(UUIDCreater.getUUID());
								organize.setCreatedate(new Date()); 
								organize.setParentid(organizeId);
								organize.setLayer(3);
								organize.setDeletemark(0);
								organize.setSortcode(a);
								organizeService.insertSelective(organize);
								oragenizeAll.add(organize);
								policeofficer.setUnitid(organize.getFuid());
							}
							if (uid != null) {
								policeofficer.setFuid(uid);
								policeofficerService.updateSelective(policeofficer);
							} else {
								policeofficer.setFuid(UUIDCreater.getUUID());
								policeofficerService.insert(policeofficer);
							}
						}
						model.put("re", "1");
					} else {
						model.put("re", "2");
					}

				} catch (IOException e) {
					model.put("re", "2");
				}
			}
		}
		return "redirect:/backstage/policeofficer/showImport.html";
	}

	private String IsExistPolice(List<Policeofficer> AllData, String policenum) {
		String re = null;
		if (AllData != null && AllData.size() > 0) {
			for (Policeofficer p : AllData) {
				if (p.getPolicenum().equals(policenum)) {
					re = p.getFuid();
					break;
				}
			}
		}
		return re;
	}

	private String IsExistOragenize(List<Organize> AllData, String orgName) {
		String re = null;
		if (AllData != null && AllData.size() > 0) {
			for (Organize p : AllData) {
				if (p.getFullname().equals(orgName)) {
					re = p.getFuid();
					break;
				}
			}
		}
		return re;
	}
}
