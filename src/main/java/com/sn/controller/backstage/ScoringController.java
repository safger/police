package com.sn.controller.backstage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.entity.Organize;
import com.sn.entity.Scoring;
import com.sn.service.OrganizeService;
import com.sn.service.ScoringService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/backstage/scoring")
public class ScoringController  {
	
	@Autowired
	private ScoringService scoringService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	@Autowired
	private OrganizeService organizeService;
	private ComData com;
	
	
	
	/**
	 * @see 定义接受的时间格式
	 */
	 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
	public String show(String type,Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		/*com=CompetenceManager.getCom(roleid, "/backstage/scoring/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}*/
		Organize organize = new Organize(); 
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll", oragenizeAll.getDataList());
		model.put("active", "scoring");
		model.put("com", com);
		if(type!=null&&type.equals("002001")){
			return "/backstage/scoring"; 
		}else{
			return "/backstage/scoring_tz"; 
		}
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
	public Map<String,Object> getDate(String type,Integer draw,Map<String,Object> model){
		String departmentid=(String)request.getSession().getAttribute("departmentid");
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
			case "1" : orderByStr = " departmentname";break;
			case "3" : orderByStr = " jname";break;
			case "4" : orderByStr = " sex";break; 
			case "5" : orderByStr = " ispolice";break;
			case "6" : orderByStr = " score";break;
			case "7" : orderByStr = " duties";break;
			case "9" : orderByStr = " inspectors";break;
			case "10" : orderByStr = " signer";break;
			case "11" : orderByStr = " stime";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Scoring scoring=new Scoring();
		//排除警务督察和超级管理员
		if(!"cd384f7c041a4652b901fa9cd31cdb94".equals(departmentid)&&!"sdfa".equals(departmentid)){
			scoring.setDepartmentid(departmentid);
		}
		
		//解析高级搜索
				try {
					if(value != null && value[0].length() > 0) {
						String[] data=value[0].split(",");
						if(data[0]!=null&&!data[0].equals("0")){
							scoring.setJqdepartmentid(data[0]);
						}
						if(!data[1].equals("2")){
							scoring.setIschief(Integer.parseInt(data[1]));
						}
						if(!data[2].equals("2")){
							scoring.setIspolice(Integer.parseInt(data[2]));
						}
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						if(data[3]!=null&&data[3].trim().length()>0){
							scoring.setStime(dateFormat.parse(data[3].trim()));
						}
						if(data[4]!=null&&data[4].trim().length()>0){
							scoring.setCreatedate(dateFormat.parse(data[4].trim()));
						}
						if(data[5]!=null&&data[5].trim().length()>0){
							scoring.setDstime(dateFormat.parse(data[5].trim()));
						}
						if(data[6]!=null&&data[6].trim().length()>0){
							scoring.setDetime(dateFormat.parse(data[6].trim()));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		scoring.setType(type);
		PagedResult<Scoring>  page_list = scoringService.findByPageCustom(scoring, indexPage, pageSize, orderByStr);
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
	public Result getEditData(String fuid,Map<String,Object> model) throws IOException{
		Result result = new Result();
		Scoring scoring = scoringService.findById(fuid);
		model.put("scoring", scoring);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param scoring 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Scoring scoring,Map<String,Object>model) throws IOException{
		String departmentid=(String)request.getSession().getAttribute("departmentid");
		String departmentname=(String)request.getSession().getAttribute("departmentname");
		Result result = new Result();
		String id=scoring.getFuid();
		if(id!=null&&id.length()>0){
			scoringService.updateSelective(scoring);
		}else{
			scoring.setFuid(UUIDCreater.getUUID()); 
			scoring.setCreatedate(new Date());
			scoring.setDepartmentid(departmentid);
			scoring.setDepartmentname(departmentname);
			scoringService.insertSelective(scoring);
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
			scoringService.deleteById(fuid);
		} 
		return result;
	}
	
}
