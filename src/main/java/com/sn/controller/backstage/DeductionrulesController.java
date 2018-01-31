package com.sn.controller.backstage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.Deductionrules;
import com.sn.service.DeductionrulesService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


 
@Controller
@RequestMapping("/backstage/deductionrules")
public class DeductionrulesController  {
	
	@Autowired
	private DeductionrulesService deductionrulesService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	private ComData com;
	
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model 
	 * @return
	 */
	@RequestMapping("show")
	public String show(Map<String,Object>model){
		String roleid=(String)request.getSession().getAttribute("roleid"); 
		com=CompetenceManager.getCom(roleid, "/backstage/deductionrules/show.html");
		if(!com.getHisSelect()){
			return "error";
		} 
		model.put("active", "deductionrules");
		model.put("com", com);
		return "/backstage/deductionrules"; 
	}
	 
	/**
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage 当前页
	 * @param pageSize 每页显示条数
	 * @param model 
	 * @return
	 */
	@RequestMapping("getDate")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String,Object> getDate(Integer draw,Map<String,Object> model){
		//每页返回的条数
		int pageSize = 10;
		String length = request.getParameter("length");
		if(!StringUtils.isEmpty(length)){
			pageSize = Integer.parseInt(length);
		}
		int start = Integer.parseInt(request.getParameter("start"));
		int indexPage = start / pageSize + 1;
		Map<String, String[]> params = request.getParameterMap();
		String[] sort = params.get("order[0][column]");
		String[] desc = params.get("order[0][dir]");
		String[] value = params.get("search[value]");
		
		String orderByStr = null;
		switch(sort[0]){
			case "1" : orderByStr = " title";break;
			case "2" : orderByStr = " regulations";break;
			case "3" : orderByStr = " score";break;
			case "4" : orderByStr = " sortcode";break;
			case "5" : orderByStr = " content";break;
			case "6" : orderByStr = " modifydate";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Deductionrules deductionrules=new Deductionrules();
		if(value != null && value[0].length() > 0){
			deductionrules.setTitle(value[0]);
		}
		PagedResult<Deductionrules>  page_list = deductionrulesService.findByPageCustom(deductionrules, indexPage, pageSize, orderByStr);
		List<Deductionrules> dlist=page_list.getDataList();
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		for(Deductionrules _deductionrules:dlist){ 
			_deductionrules.setRegulations(DatadictionaryMap.get(_deductionrules.getRegulations()));
		}
		model.put("recordsTotal", page_list.getTotal()); 
		model.put("recordsFiltered", page_list.getTotal()); 
		model.put("draw", draw);   
		model.put("data", dlist); 
		return model;
	}

	/**
	 * @see 获得编辑数据
	 * @author xiao
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getEditData") 
	@ResponseBody
	public Result getEditData(String fuid,Map<String,Object> model) throws IOException{
		Result result = new Result();
		Deductionrules deductionrules = deductionrulesService.findById(fuid); 
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		model.put("deductionrulesData", deductionrules.getRegulations());
		deductionrules.setRegulations(DatadictionaryMap.get(deductionrules.getRegulations()));
		model.put("deductionrules", deductionrules);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param deductionrules 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Deductionrules deductionrules,Map<String,Object>model) throws IOException{
		Result result = new Result();
		String id=deductionrules.getFuid();
		if(id!=null&&id.length()>0){
			deductionrules.setModifydate(new Date());
			deductionrulesService.updateSelective(deductionrules);
		}else{
			deductionrules.setFuid(UUIDCreater.getUUID()); 
			deductionrules.setModifydate(new Date());
			deductionrules.setCreatedate(new Date());
			deductionrulesService.insertSelective(deductionrules);
		}
		return result;
	}
	
	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param id 主键
	 * @param model
	 * @return 列表显示页
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String fuid){
		Result result = new Result();
		if(fuid!=null&&fuid.length()>0){
			deductionrulesService.deleteById(fuid);
		} 
		return result;
	}
	/**
	 * @see 查询条款
	 * @author xiao
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("getTerms")
	@ResponseBody
	public String getTerms(String code) throws IOException{
		PrintWriter out=response.getWriter();
		Deductionrules deductionrules=new Deductionrules();
		deductionrules.setRegulations(code);
		List<Deductionrules> deductionrules_list=deductionrulesService.selectByColum(deductionrules, "title");
		out.print(JSONArray.toJSON(deductionrules_list));
		return null;
	}
	
}
