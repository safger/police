package com.sn.controller.backstage;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.tempuri.ws_xsd.service.Service;
import org.tempuri.ws_xsd.service.ServicePortType;

import com.sn.common.ExcelHelper;
import com.sn.common.FileUpload;
import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.Fvisits;
import com.sn.entity.Organize;
import com.sn.entity.Policeofficer;
import com.sn.service.FvisitsService;
import com.sn.type.Result;
import com.sn.util.PagedResult;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/backstage/fvisits")
public class FvisitsController {

	@Autowired
	private FvisitsService fvisitsService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	private ComData com;

	/**
	 * @see 定义接受的时间格式
	 */

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

		String roleid = (String) request.getSession().getAttribute("roleid");
		com = CompetenceManager.getCom(roleid, "/backstage/fvisits/show.html");
		if (!com.getHisSelect()) {
			return "error";
		}
		model.put("active", "fvisits");
		model.put("com", com);
		return "/backstage/fvisits";
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
	public Map<String, Object> getDate(Integer draw, Integer page, String ps, Map<String, Object> model) {
		// 每页返回的条数
		int pageSize = 10;
		if (page != null) {
			pageSize = page;
		}
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
			orderByStr = " xno";
			break;
		case "2":
			orderByStr = " fname";
			break;
		case "3":
			orderByStr = " xcode";
			break;
		case "4":
			orderByStr = " xdate";
			break;
		case "5":
			orderByStr = " xstatus";
			break;
		case "6":
			orderByStr = " xdays";
			break;
		case "7":
			orderByStr = " rperson";
			break;
		case "8":
			orderByStr = " bstatus";
			break;
		case "9":
			orderByStr = " isreported";
			break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Fvisits fvisits = new Fvisits();
		if (value != null && value[0].length() > 0) {
			fvisits.setXno(value[0]);
		}
		if (ps != null) {
			fvisits.setIsreported(1.0);
		}
		PagedResult<Fvisits> page_list = fvisitsService.findByPageCustom(fvisits, indexPage, pageSize, orderByStr);
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
		Fvisits fvisits = fvisitsService.findById(fuid);
		model.put("fvisits", fvisits);
		result.setData(model);
		return result;
	}

	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param fvisits
	 *            实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Fvisits fvisits, Map<String, Object> model) throws IOException {
		Result result = new Result();
		String userid = (String) request.getSession().getAttribute("userid");
		String id = fvisits.getFuid();
		fvisits.setModifydate(new Date());
		if (id != null && id.length() > 0) {
			fvisitsService.updateSelective(fvisits);
		} else {
			fvisits.setFuid(UUIDCreater.getUUID());
			fvisits.setCreatedate(new Date());
			fvisitsService.insertSelective(fvisits);
		}
		return result;
	}

	/**
	 * @see 领导批示
	 * @author xiao
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("inst")
	@ResponseBody
	public String inst(String fuid, String instructions) {
		if (instructions != null && instructions.trim().length() > 0) {
			Fvisits fvisits = fvisitsService.findById(fuid);
			fvisits.setInstructions(instructions);
			fvisitsService.updateSelective(fvisits);
		}
		return null;
	}

	/**
	 * @see 上报领导
	 * @author xiao
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("reported")
	@ResponseBody
	public Result reported(Fvisits fvisits, Map<String, Object> model) throws IOException {
		Result result = new Result();
		String id = fvisits.getFuid();
		fvisits.setModifydate(new Date());
		if (id != null && id.length() > 0) {
			fvisits.setIsreported(1.0);
			fvisitsService.updateSelective(fvisits);
		}
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
			fvisitsService.deleteById(fuid);
		}
		return result;
	}

	/**
	 * @see 数据导入
	 * @author xiao
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("EImport")
	public String EImport(@RequestParam(value = "exfile") MultipartFile[] exfile, String organizeId, Map<String, Object> model) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (exfile != null && !exfile[0].isEmpty()) {
			ArrayList<String> file_list = FileUpload.uploadFile(exfile, request, false);
			if (file_list != null && file_list.size() > 0) {
				String path = request.getSession().getServletContext().getRealPath("/") + FileUpload.FILE_PATH + file_list.get(0);
				// 解析EXCEL
				List<String> list = null;
				try {
					list = ExcelHelper.exportListFromExcel(new File(path), 0);
					if (list != null && list.size() > 0) {
						for (int a = 1; a < list.size(); a++) {
							String ll = list.get(a);
							String data[] = ll.split("\\|");
							if (data.length > 7) {
								Fvisits fvisits = new Fvisits();
								// 判断原始数据是否存在
								try {
									fvisits.setCreatedate(new Date());
									fvisits.setFname(data[1]);
									fvisits.setXcode(data[3]);
									fvisits.setRperson("5177");
									fvisits.setAdress(data[4]);
									fvisits.setXdate(dateFormat.parse(data[5].trim()));
									fvisits.setFcontet(data[6]);
									fvisits.setHousehold(data[7]);
									fvisits.setXno(data[2]);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								fvisits.setFuid(UUIDCreater.getUUID());
								fvisitsService.insert(fvisits);

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
}
