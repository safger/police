package com.sn.controller.backstage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.UUIDCreater;
import com.sn.type.Result;
import com.sn.util.PagedResult;
 

import java.util.*;
import java.io.IOException;  
 


import com.sn.entity.*;
import com.sn.dao.*;
import com.sn.service.*;  
import com.sn.util.PagedResult;
import com.sn.common.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sn.controller.system.CompetenceManager;

import javax.servlet.http.HttpServletRequest;

import com.sn.controller.system.ComData;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/backstage/traffic")
public class TrafficController  {
	
	@Autowired
	private TrafficService trafficService;
	@Autowired
	private VehicleperService vehicleperService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
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
	public String show(Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "/backstage/traffic/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "traffic");
		model.put("com", com);
		return "/backstage/traffic"; 
	}
	
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model 
	 * @return 
	 */
	@RequestMapping("showLate")
	public String showLate(Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "/backstage/traffic/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "traffic");
		model.put("com", com);
		return "/backstage/trafficLate"; 
	}
	 
	/**
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage 当前页
	 * @param pageSize 每页显示条数
	 * @param model 
	 * @return
	 */
	@RequestMapping("getDataLate")
	@ResponseBody
	public Map<String,Object> getDataLate(Integer draw,Map<String,Object> model){
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
		case "1" : orderByStr = " licenseplate";break;
		case "2" : orderByStr = " tdate";break;
		case "3" : orderByStr = " gateway";break;
		case "4" : orderByStr = " lanename";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Traffic traffic=new Traffic();  
		traffic.setAccesstype("入场");
		//解析高级搜索
		try {
			if(value != null && value[0].length() > 0) {
				traffic.setAccesstype(value[0]); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PagedResult<Traffic>  page_list = trafficService.findByPageLate(traffic, indexPage, pageSize, orderByStr);
		model.put("recordsTotal", page_list.getTotal()); 
		model.put("recordsFiltered", page_list.getTotal()); 
		model.put("draw", draw);  
		model.put("data", page_list.getDataList()); 
		return model;
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
			case "1" : orderByStr = " licenseplate";break;
			case "2" : orderByStr = " tdate";break;
			case "3" : orderByStr = " gateway";break;
			case "4" : orderByStr = " lanename";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Traffic traffic=new Traffic();  
		//解析高级搜索
				try {
					if(value != null && value[0].length() > 0) {
						String[] data=value[0].split(",");
						if(data[0]!=null&&!data[0].equals("0")){
							traffic.setLicenseplate(data[0]);
						}
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						if(data[1]!=null&&data[1].trim().length()>0){
							traffic.setTdate(dateFormat.parse(data[1].trim()));
						}
						if(data[2]!=null&&data[2].trim().length()>0){
							traffic.setCreatedate(dateFormat.parse(data[2].trim()));
						} 
						if(data[3]!=null&&data[3].trim().length()>0){
							traffic.setAccesstype(data[3]);
						} 
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		PagedResult<Traffic>  page_list = trafficService.findByPageCustom(traffic, indexPage, pageSize, orderByStr);
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
		Traffic traffic = trafficService.findById(fuid);
		model.put("traffic", traffic);
		result.setData(model);
		return result;
	}
	
 
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model 
	 * @return 
	 */
	@RequestMapping("showProblem")
	public String showProblem(Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "/backstage/traffic/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "trafficProblem");
		model.put("com", com);
		return "/backstage/trafficProblem"; 
	}
	 
	/** 
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage 当前页
	 * @param pageSize 每页显示条数
	 * @param model 
	 * @return 
	 */
	@RequestMapping("trafficProblem")
	@ResponseBody
	public Map<String,Object> geProblemtData(Integer draw,Map<String,Object> model){
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
			case "1" : orderByStr = " licenseplate";break;
			case "2" : orderByStr = " s1tdate";break;
			case "3" : orderByStr = " s2tdate";break;
			case "4" : orderByStr = " jtimes";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Traffic traffic=new Traffic();  
		//解析高级搜索
				try {
					if(value != null && value[0].length() > 0) {
						String[] data=value[0].split(",");
						if(data[0]!=null&&!data[0].equals("0")){
							traffic.setLicenseplate(data[0]);
						}
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						if(data[1]!=null&&data[1].trim().length()>0){
							traffic.setS1tdate(dateFormat.parse(data[1].trim()));
						}
						if(data[2]!=null&&data[2].trim().length()>0){
							traffic.setCreatedate(dateFormat.parse(data[2].trim()));
						} 
						if(data[3]!=null&&data[3].trim().length()>0){
							traffic.setJtimes(Double.parseDouble(data[3].trim()));
						} 
						if(data[4]!=null&&data[4].trim().length()>0){
							traffic.setS2tdate(dateFormat.parse(data[4].trim()));
						}
						if(data[5]!=null&&data[5].trim().length()>0){
							traffic.setTdate(dateFormat.parse(data[5].trim()));
						} 
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		PagedResult<Traffic>  page_list = trafficService.selectByProblem(traffic, indexPage, pageSize, orderByStr);
		List<Traffic> tra_list=page_list.getDataList();
		if(tra_list!=null&&tra_list.size()>0){
			for(Traffic t:tra_list){
				Vehicleper v=vehicleperService.findById(t.getLicenseplate());
				if(v!=null){
					t.setPhone(v.getPhone());
					t.setOwer(v.getOwner());
				}
			}
		}
		
		model.put("recordsTotal", page_list.getTotal()); 
		model.put("recordsFiltered", page_list.getTotal()); 
		model.put("draw", draw);  
		model.put("data", tra_list); 
		return model;
	}

}
