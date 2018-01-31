package com.sn.controller.backstage;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.Deductionrules;
import com.sn.entity.Organize;
import com.sn.entity.Problemdata;
import com.sn.service.DeductionrulesService;
import com.sn.service.OrganizeService;
import com.sn.service.PoliceofficerService;
import com.sn.service.ProblemdataService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/backstage/problemdata")
public class ProblemdataController  {
	
	@Autowired
	private ProblemdataService problemdataService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	@Autowired
	private DeductionrulesService deductionrulesService;
	@Autowired
	private PoliceofficerService policeofficerService;
	@Autowired
	private OrganizeService organizeService;
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
		String departmentid=(String)request.getSession().getAttribute("departmentid");
		String functional=(String)request.getSession().getAttribute("functional");
		com=CompetenceManager.getCom(roleid, "/backstage/problemdata/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		//-------提醒
		if(functional==null||!functional.equals("1")){
			Problemdata problemdata=new Problemdata();
			problemdata.setCdepartmentid(departmentid);
			problemdata.setJtype(1);
			Integer t=problemdataService.countByScore(problemdata);
			if(t!=null&&t>0){
				t=t*7/3; 
			}
			model.put("tx", t);
			
		}
		//----------
		Organize organize = new Organize(); 
		organize.setLayer(2);
		String dname=(String)request.getSession().getAttribute("departmentname");
		if(functional!=null&&functional.equals("1")){
			PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
			model.put("oragenizeAll", oragenizeAll.getDataList());
			model.put("dc", "dc");
		}else{
			Organize o = organizeService.findById(departmentid);
			String parendid = o.getParentid(); 
			Organize po = organizeService.findById(parendid);
			model.put("cdepartmentid", departmentid);
			model.put("cdepartmentname", dname);
			model.put("departmentid", parendid);
			model.put("departmentname", po.getFullname());
		}
		
		model.put("active", "problemdata");
		model.put("com", com);
		return "/backstage/problemdata"; 
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
	public Map<String,Object> getDate(Integer draw,Integer page,Map<String,Object> model){
		String departmentid = (String) request.getSession().getAttribute("departmentid");
		String functional = (String) request.getSession().getAttribute("functional");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//每页返回的条数
		int pageSize = 10;
		if(page!=null){
			pageSize=page;
		}
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
			case "1" : orderByStr = " hmd";break;
			case "2" : orderByStr = " name";break; 
			case "3" : orderByStr = " chapter";break;
			case "4" : orderByStr = " terms";break;
			case "5" : orderByStr = " score";break; 
			case "8" : orderByStr = " orrurdate";break;
			case "9" : orderByStr = " createdate";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		Problemdata problemdata=new Problemdata();
		//解析高级搜索 
				try {
					if(value != null && value[0].length() > 0) {
						String[] data=value[0].split(",");
						if(data[0]!=null&&!data[0].equals("-1")){
							problemdata.setDepartmentid(data[0]);
						} 
						if(!data[1].equals("2")){
							problemdata.setIspolice(Integer.parseInt(data[1]));
						}
						if(!data[2].equals("2")){
							problemdata.setDtype(Integer.parseInt(data[2]));
						}
						if(data[3]!=null&&!data[3].equals("-1")){
							problemdata.setRulesid(data[3]); 
						} 
						if(data[4]!=null&&!data[4].equals("-1")){ 
							problemdata.setChapter(data[4]);
						}  
						if(data[5]!=null&&!data[5].equals("-1")){ 
							problemdata.setCdepartmentid(data[5]);
						} 
						if(data[6]!=null&&data[6].length()>0){ 
							problemdata.setHmd(data[6]);
						} 
						if(data[7]!=null&&data[7].length()>0){ 
							problemdata.setName(data[7]);
						} 
						if(data[8]!=null&&data[8].length()>0){ 
							problemdata.setCreatedate(dateFormat.parse(data[8]));;
						} 
						if(data[9]!=null&&data[9].length()>0){ 
							problemdata.setModifydate(dateFormat.parse(data[9]));;
						} 
					} 
				} catch (Exception e) {
					e.printStackTrace();
				} 
				// ---------数据权限
				problemdata.setZfcdepartmentid("tettt");
				if(!departmentid.equals("sdfa")){
					Organize o = organizeService.findById(departmentid);
					String parendid = o.getParentid(); 
					if(functional!=null&&functional.equals("1")){
						problemdata.setDepartmentid(parendid);
					}else{
						problemdata.setCdepartmentid(departmentid);
					}
					problemdata.setZfcdepartmentid(departmentid);
				}
				
		PagedResult<Problemdata>  page_list = problemdataService.findByPageCustom(problemdata, indexPage, pageSize, orderByStr);
		Integer zf=problemdataService.countByJf(problemdata);
		zf=zf==null?0:zf;
		List<Problemdata> proList=page_list.getDataList();
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		if(proList!=null&&proList.size()>0){ 
			for(Problemdata pro:proList){ 
				pro.setChapter(DatadictionaryMap.get(pro.getChapter()));
			} 
		} 
		model.put("recordsTotal", page_list.getTotal()); 
		model.put("recordsFiltered", page_list.getTotal()); 
		model.put("zf", zf);  
		model.put("draw", draw);  
		model.put("data", proList); 
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
		Map<String, String> DatadictionaryMap=(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		Problemdata problemdata = problemdataService.findById(fuid);
		problemdata.setPerid(DatadictionaryMap.get(problemdata.getChapter()));
		model.put("problemdata", problemdata);
		result.setData(model);
		return result;
	}
	
	
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param problemdata 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(Problemdata problemdata,Map<String,Object>model) throws IOException{
		Result result = new Result();
		String username = (String)request.getSession().getAttribute("username");
		String departmentid=(String)request.getSession().getAttribute("departmentid");
		String departmentname=(String)request.getSession().getAttribute("departmentname");
		String functional=(String)request.getSession().getAttribute("functional");
		String id=problemdata.getFuid();
		request.getSession().removeAttribute("jg");
		if(id!=null&&id.length()>0){
			String termsId=problemdata.getTerms();
			Deductionrules deductionrules=deductionrulesService.findById(termsId);
			problemdata.setRulesid(termsId);
			if(problemdata.getDepartmentid()!=null&&problemdata.getDepartmentid().length()==0){
				problemdata.setDepartmentid(null);
			}
			if(problemdata.getDepartment()!=null&&problemdata.getDepartment().length()==0){
				problemdata.setDepartment(null);
			}
			problemdata.setTerms(deductionrules.getTitle());
			problemdata.setModifydate(new Date()); 
			problemdataService.updateSelective(problemdata);
		}else{
			problemdata.setFuid(UUIDCreater.getUUID()); 
			//String perid=problemdata.getName();
			//Policeofficer policeofficer=policeofficerService.findById(perid);
			//problemdata.setPerid(perid);
			String termsId=problemdata.getTerms();
			Deductionrules deductionrules=deductionrulesService.findById(termsId);
			problemdata.setRulesid(termsId);
			problemdata.setTerms(deductionrules.getTitle());
			problemdata.setLocking(0);
			problemdata.setRecorder(username);
			problemdata.setModifydate(new Date()); 
			problemdata.setCreatedate(new Date());
			//-------判断是否自主记分
			String cdepartmentid=problemdata.getCdepartmentid();
			if(departmentid.equals(cdepartmentid)){
				problemdata.setJftype(1);
			}else{
				problemdata.setJftype(0);
			}
			if(functional!=null&&functional.equals("1")){
				problemdata.setJtype(1);
			} 
			problemdataService.insertSelective(problemdata);
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
			problemdataService.deleteById(fuid);
		} 
		return result;
	}
	
	@RequestMapping("editZf")
	@ResponseBody
	public Result editZf(Problemdata problemdata,Map<String,Object>model) {
		problemdata.setZstatus(1);
		problemdataService.updateSelective(problemdata);
		return null;
	}
	@RequestMapping("editZH")
	@ResponseBody
	public Result editZH(Problemdata problemdata,Map<String,Object>model) {
		problemdata.setZstatus(2);
		problemdataService.updateSelective(problemdata);
		return null;
	}
	
}
