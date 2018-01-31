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
@RequestMapping("/backstage/pedestrian")
public class PedestrianController  {
	
	@Autowired
	private PedestrianService pedestrianService;
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
		com=CompetenceManager.getCom(roleid, "/backstage/pedestrian/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "pedestrian");
		model.put("com", com);
		return "/backstage/pedestrian"; 
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
			case "1" : orderByStr = " personname";break;
			case "2" : orderByStr = " card";break;
			case "3" : orderByStr = " eventname";break;
			case "4" : orderByStr = " eventtime";break;
			case "5" : orderByStr = " deptname";break;
			case "6" : orderByStr = " doorname";break;
			case "7" : orderByStr = " devicename";break; 
		}
		orderByStr = orderByStr + " " + desc[0];
		Pedestrian pedestrian=new Pedestrian();
		//解析高级搜索
		try {
			if(value != null && value[0].length() > 0) {
				String[] data=value[0].split(",");
				System.out.println(value[0]);
				System.out.println(data[0]);
				if(data[0]!=null&&data[0].trim().length()>0){
					pedestrian.setPersonname(data[0]);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if(data[1]!=null&&data[1].trim().length()>0){
					pedestrian.setEventtime(dateFormat.parse(data[1].trim()));
				}
				if(data[2]!=null&&data[2].trim().length()>0){
					Date edate=dateFormat.parse(data[2].trim());
					Calendar date = Calendar.getInstance();
					date.setTime(edate);
					date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
					pedestrian.setCreatedate(date.getTime());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PagedResult<Pedestrian>  page_list = pedestrianService.findByPageCustom(pedestrian, indexPage, pageSize, orderByStr);
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
		Pedestrian pedestrian = pedestrianService.findById(fuid);
		model.put("pedestrian", pedestrian);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param pedestrian 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Pedestrian pedestrian,Map<String,Object>model) throws IOException{
		Result result = new Result();
		String userid = (String)request.getSession().getAttribute("userid");
		String id=pedestrian.getFuid();
		if(id!=null&&id.length()>0){
			pedestrianService.updateSelective(pedestrian);
		}else{
			pedestrian.setFuid(UUIDCreater.getUUID()); 
			pedestrian.setCreatedate(new Date());
			pedestrianService.insertSelective(pedestrian);
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
			pedestrianService.deleteById(fuid);
		} 
		return result;
	}
	
}
