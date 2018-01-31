package com.sn.controller.backstage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.sn.common.DateUtil;
import com.sn.controller.system.ComData;
import com.sn.entity.Datadictionary;
import com.sn.entity.Inspector;
import com.sn.entity.Organize;
import com.sn.entity.Problemdata;
import com.sn.entity.Scoring;
import com.sn.entity.echarts;
import com.sn.service.DatadictionaryService;
import com.sn.service.InspectorService;
import com.sn.service.OrganizeService;
import com.sn.service.ProblemdataService;
import com.sn.service.ScoringService;
import com.sn.util.PagedResult;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/backstage/statistics")
public class StatisticsController {

	@Autowired
	private InspectorService inspectorService;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private DatadictionaryService datadictionaryService;
	@Autowired
	private ProblemdataService problemdataService;
	@Autowired
	private ScoringService scoringService;

	private ComData com;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	/**
	 * @see 分析网上督察占比
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("showInspector")
	public String showInspector(Date etime, Date stime, String type, Map<String, Object> model) {
		// 问题类型---------------------
		Calendar calendar = Calendar.getInstance();
		type = type == null ? "" : type;
		Datadictionary datadictionary = new Datadictionary();
		datadictionary.setCode("003");
		PagedResult<Datadictionary> data_page = datadictionaryService.findByPageCustom(datadictionary, 1, 999, "code");
		List<Datadictionary> d_list = data_page.getDataList();
		String[] bt = new String[d_list.size()];
		List<echarts> echarts_data = new ArrayList<echarts>();
		Map<String, String> DatadictionaryMap = (Map<String, String>) request.getServletContext().getAttribute("DatadictionaryMap");
		Inspector inspector = new Inspector();
		for (int a = 0; a < d_list.size(); a++) {
			bt[a] = d_list.get(a).getFullname();
			String code = d_list.get(a).getCode();
			inspector.setDescription(code);
			switch (type) {
			case "zdy":
				inspector.setCreatedate(stime);
				inspector.setModifydate(etime);
				break;
			case "thisMonth":
				inspector.setCreatedate(DateUtil.getBeginDayOfMonth());
				inspector.setModifydate(new Date());
				break;
			case "lastMonth":
				// 上个月第一天
				calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, 1);
				inspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
				// 上个月最后一天
				int day = calendar.getActualMaximum(5);
				calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, day);
				inspector.setModifydate(DateUtil.getDayEndTime(calendar.getTime()));
				break;
			case "threeMonth":
				calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 3, 1);
				inspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
				inspector.setModifydate(new Date());
				break;
			case "year":
				inspector.setCreatedate(DateUtil.getBeginDayOfYear());
				inspector.setModifydate(new Date());
				break;
			default:
				break;
			}
			int count = inspectorService.countByCustom(inspector);
			echarts e = new echarts();
			e.setName(DatadictionaryMap.get(code));
			e.setValue((double) count);
			echarts_data.add(e);
		}
		model.put("bt", bt);
		model.put("e_data", JSONArray.toJSON(echarts_data));
		// ----------------问题公安
		List<echarts> lx_data = new ArrayList<echarts>();
		Inspector in = new Inspector();
		switch (type) {
		case "zdy":
			in.setCreatedate(stime);
			in.setModifydate(etime);
			break;
		case "thisMonth":
			in.setCreatedate(DateUtil.getBeginDayOfMonth());
			in.setModifydate(new Date());
			break;
		case "lastMonth":
			// 上个月第一天
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, 1);
			in.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			// 上个月最后一天
			int day = calendar.getActualMaximum(5);
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, day);
			in.setModifydate(DateUtil.getDayEndTime(calendar.getTime()));
			break;
		case "threeMonth":
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 3, 1);
			in.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			in.setModifydate(new Date());
			break;
		case "year":
			in.setCreatedate(DateUtil.getBeginDayOfYear());
			in.setModifydate(new Date());
			break;
		default:
			break;
		}

		List<Inspector> in_list = inspectorService.selectByGroup(in);
		String[] lx = new String[in_list.size()];
		for (int a = 0; a < in_list.size(); a++) {
			lx[a] = in_list.get(a).getQdepartment();
			Inspector inn = new Inspector();
			inn.setQdepartmentid(in_list.get(a).getQdepartmentid());
			int count = inspectorService.countByCustom(inn);
			echarts e = new echarts();
			e.setName(in_list.get(a).getQdepartment());
			e.setValue((double) count);
			lx_data.add(e);
		}
		model.put("lx", lx);
		model.put("lx_data", JSONArray.toJSON(lx_data));
		// ----------------问题监控
		datadictionary.setCode("004");
		PagedResult<Datadictionary> jk_page = datadictionaryService.findByPageCustom(datadictionary, 1, 999, "code");
		List<Datadictionary> jk_list = jk_page.getDataList();
		String[] jk = new String[jk_list.size()];
		List<echarts> jkecharts_data = new ArrayList<echarts>();
		Inspector _inspector = new Inspector();
		for (int a = 0; a < jk_list.size(); a++) {
			jk[a] = jk_list.get(a).getFullname();
			String code = jk_list.get(a).getCode();
			_inspector.setDescription(code);
			switch (type) {
			case "zdy":
				_inspector.setCreatedate(stime);
				_inspector.setModifydate(etime);
				break;
			case "thisMonth":
				_inspector.setCreatedate(DateUtil.getBeginDayOfMonth());
				_inspector.setModifydate(new Date());
				break;
			case "lastMonth":
				// 上个月第一天
				calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, 1);
				_inspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
				// 上个月最后一天
				int day = calendar.getActualMaximum(5);
				calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, day);
				_inspector.setModifydate(DateUtil.getDayEndTime(calendar.getTime()));
				break;
			case "threeMonth":
				calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 3, 1);
				_inspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
				_inspector.setModifydate(new Date());
				break;
			case "year":
				_inspector.setCreatedate(DateUtil.getBeginDayOfYear());
				_inspector.setModifydate(new Date());
				break;
			default:
				break;
			}
			int count = inspectorService.countByCustom(_inspector);
			echarts e = new echarts();
			e.setName(DatadictionaryMap.get(code));
			e.setValue((double) count);
			jkecharts_data.add(e);
		}
		model.put("jk", jk);
		model.put("jk_data", JSONArray.toJSON(jkecharts_data));
		// ----------------监控人员问题
		String[] jkry = new String[] { "监控问题", "人员问题" };
		List<echarts> jkryecharts_data = new ArrayList<echarts>();
		Inspector _jinspector = new Inspector();
		switch (type) {
		case "zdy":
			_jinspector.setCreatedate(stime);
			_jinspector.setModifydate(etime);
			break;
		case "thisMonth":
			_jinspector.setCreatedate(DateUtil.getBeginDayOfMonth());
			_jinspector.setModifydate(new Date());
			break;
		case "lastMonth":
			// 上个月第一天
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, 1);
			_jinspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			// 上个月最后一天
			int day = calendar.getActualMaximum(5);
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, day);
			_jinspector.setModifydate(DateUtil.getDayEndTime(calendar.getTime()));
			break;
		case "threeMonth":
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 3, 1);
			_jinspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			_jinspector.setModifydate(new Date());
			break;
		case "year":
			_jinspector.setCreatedate(DateUtil.getBeginDayOfYear());
			_jinspector.setModifydate(new Date());
			break;
		default:
			break;
		}
		_jinspector.setQtype("0");
		int jkcount = inspectorService.countByCustom(_jinspector);
		echarts e = new echarts();
		e.setName(jkry[0]);
		e.setValue((double) jkcount);
		jkryecharts_data.add(e);
		_jinspector.setQtype("1");
		int rycount = inspectorService.countByCustom(_jinspector);
		echarts _e = new echarts();
		_e.setName(jkry[1]);
		_e.setValue((double) rycount);
		jkryecharts_data.add(_e);
		model.put("jkry", jkry);
		model.put("jkryecharts_data", JSONArray.toJSON(jkryecharts_data));
		model.put("stime", stime);
		model.put("etime", etime);
		return "/backstage/StatisticsInspector";
	}

	/**
	 * @see 统计网上督察
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("stInspector")
	public String stInspector(Date etime, Date stime, String type,String ext, Map<String, Object> model) {
		Inspector inspector = new Inspector();
		Calendar calendar = Calendar.getInstance();
		type = type == null ? "zdy" : type;
		switch (type) {
		case "zdy":
			inspector.setCreatedate(stime);
			inspector.setModifydate(etime);
			break;
		case "thisMonth":
			inspector.setCreatedate(DateUtil.getBeginDayOfMonth());
			inspector.setModifydate(new Date());
			break;
		case "lastMonth":
			// 上个月第一天
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, 1);
			inspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			// 上个月最后一天
			int day = calendar.getActualMaximum(5);
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, day);
			inspector.setModifydate(DateUtil.getDayEndTime(calendar.getTime()));
			break;
		case "threeMonth":
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 3, 1);
			inspector.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			inspector.setModifydate(new Date());
			break;
		case "year":
			inspector.setCreatedate(DateUtil.getBeginDayOfYear());
			inspector.setModifydate(new Date());
			break;
		default:
			break;
		}
		List<Inspector> all_list = inspectorService.selectByGroup(null);
		// 人员问题
		inspector.setQtype("1");
		List<Inspector> rall_list = inspectorService.selectByGroup(inspector);
		// 已处理问题
		inspector.setTwice(1.0);
		List<Inspector> rcl_list = inspectorService.selectByGroup(inspector);
		for (Inspector rall : rall_list) {
			rall.setCold(0);
			for (Inspector rcl : rcl_list) {
				if (rcl.getQdepartment().equals(rall.getQdepartment())) {
					rall.setCold(rcl.getIsp());
					break;
				}
			}
		}
		for (Inspector all : all_list) {
			all.setCold(0);
			all.setIsp(0);
			inspector.setQdepartmentid(all.getQdepartmentid());
			inspector.setTwice(null);
			List<Inspector> type_list = inspectorService.selectByTypeGroup(inspector);
			for(Inspector i:type_list){
				switch (i.getDescription()) {
				case "003001":
					all.setWsj(i.getIsp()); 
					break;
				case "003002":
					all.setSj(i.getIsp());
					break;
				case "003003":
					all.setZzbz(i.getIsp());
					break;
				case "003004":
					all.setDrsx(i.getIsp());
					break;
				case "003005":
					all.setCq(i.getIsp());
					break;
				case "003006":
					all.setWrkg(i.getIsp());
					break;
				case "003009":
					all.setQt(i.getIsp());
					break;
				}
			} 
			
			for (Inspector rall : rall_list) {
				if (all.getQdepartment().equals(rall.getQdepartment())) {
					all.setCold(rall.getCold());
					all.setIsp(rall.getIsp());
					break;
				}
			}
		}
		// 视频问题
		inspector.setTwice(null);
		inspector.setQtype("0");
		List<Inspector> sall_list = inspectorService.selectByGroup(inspector);
		// 已处理问题
		inspector.setTwice(1.0);
		List<Inspector> scl_list = inspectorService.selectByGroup(inspector);
		for (Inspector sall : sall_list) {
			sall.setCold(0);
			for (Inspector scl : scl_list) {
				if (scl.getQdepartment().equals(sall.getQdepartment())) {
					sall.setCold(scl.getIsp());
					break;
				}
			}
		}
		List<Inspector> ssall_list=inspectorService.selectByGroup(null);
		for (Inspector all : ssall_list) {
			all.setCold(0);
			all.setIsp(0); 
			inspector.setQdepartmentid(all.getQdepartmentid());
			inspector.setTwice(null);
			List<Inspector> type_list = inspectorService.selectByTypeGroup(inspector);
			for(Inspector i:type_list){
				switch (i.getDescription()) {
				case "004001":
					all.setSpmh(i.getIsp()); 
					break;
				case "004002":
					all.setJlsb(i.getIsp());
					break;
				case "004003":
					all.setWsp(i.getIsp());
					break;
				case "004004":
					all.setHp(i.getIsp());
					break;
				case "004005":
					all.setDdcw(i.getIsp());
					break;
				}
			} 
			for (Inspector sall : sall_list) {
				if (all.getQdepartment().equals(sall.getQdepartment())) {
					all.setCold(sall.getCold());
					all.setIsp(sall.getIsp());
					break;
				}
			}  
		}
		//总统计
		Inspector count=new Inspector();
		count.setQdepartment("总共");
		count.setIsp(0);
		count.setCold(0);
		for(Inspector i:all_list){
			count.setWsj(count.getWsj()+i.getWsj());
			count.setSj(count.getSj()+i.getSj());
			count.setZzbz(count.getZzbz()+i.getZzbz());
			count.setDrsx(count.getDrsx()+i.getDrsx());
			count.setCq(count.getCq()+i.getCq());
			count.setWrkg(count.getWrkg()+i.getWrkg());
			count.setQt(count.getQt()+i.getQt());
			count.setIsp(count.getIsp()+i.getIsp());
			count.setCold(count.getCold()+i.getCold());
		}
		//总统计
		Inspector _count=new Inspector();
		_count.setIsp(0); 
		_count.setCold(0);
		_count.setQdepartment("总共");
		for(Inspector i:ssall_list){
			_count.setSpmh(_count.getSpmh()+i.getSpmh());
			_count.setJlsb(_count.getJlsb()+i.getJlsb());
			_count.setHp(_count.getHp()+i.getHp());
			_count.setDdcw(_count.getDdcw()+i.getDdcw());
			_count.setIsp(_count.getIsp()+i.getIsp());
			_count.setCold(_count.getCold()+i.getCold());
		}
		ssall_list.add(_count);
		all_list.add(count);
		model.put("rall_list", all_list);
		model.put("sall_list", ssall_list);
		if(ext!=null&&ext.equals("ext")){
			return "/backstage/stInspectorExt";
		}else{
			return "/backstage/stInspector";
		}
	}

	/**
	 * @see 分析网上督察占比
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("showScore")
	public String showScore(Scoring scoring, Date setime, Map<String, Object> model) {
		Organize organize = new Organize();
		organize.setLayer(2);
		PagedResult<Organize> oragenizeAll = organizeService.findByPageCustom(organize, 1, 1000, " fullname");
		model.put("oragenizeAll", oragenizeAll.getDataList());
		//
		String jqdepartmentid = scoring.getJqdepartmentid();
		if (jqdepartmentid != null && jqdepartmentid.equals("0")) {
			scoring.setJqdepartmentid(null);
		}
		scoring.setType("002001");
		int jf = scoringService.countByCustom(scoring);
		scoring.setType("002002");
		int tz = scoringService.countByCustom(scoring);
		scoring.setType("002003");
		int jb = scoringService.countByCustom(scoring);
		model.put("jf", jf);
		model.put("tz", tz);
		model.put("jb", jb);
		model.put("scoring", scoring);
		return "/backstage/StatisticsScore";
	}
	/**
	 * @see 统计网上督察
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("stProbleData")
	public String stProbleData(Date etime, Date stime, String type,String ext, Map<String, Object> model) {
		Problemdata problemdata = new Problemdata();
		Calendar calendar = Calendar.getInstance();
		type = type == null ? "zdy" : type;
		switch (type) {
		case "zdy":
			problemdata.setCreatedate(stime);
			problemdata.setModifydate(etime);
			break;
		case "thisMonth":
			problemdata.setCreatedate(DateUtil.getBeginDayOfMonth());
			problemdata.setModifydate(new Date());
			break;
		case "lastMonth":
			// 上个月第一天
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, 1);
			problemdata.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			// 上个月最后一天
			int day = calendar.getActualMaximum(5);
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 2, day);
			problemdata.setModifydate(DateUtil.getDayEndTime(calendar.getTime()));
			break;
		case "threeMonth":
			calendar.set(DateUtil.getNowYear(), DateUtil.getNowMonth() - 3, 1);
			problemdata.setCreatedate(DateUtil.getDayStartTime(calendar.getTime()));
			problemdata.setModifydate(new Date());
			break;
		case "year":
			problemdata.setCreatedate(DateUtil.getBeginDayOfYear());
			problemdata.setModifydate(new Date());
			break;
		default:
			break;
		}
		Datadictionary datadictionary = new Datadictionary();
		datadictionary.setCode("001");
		PagedResult<Datadictionary> data_page = datadictionaryService.findByPageCustom(datadictionary, 1, 999, "code");
		List<Datadictionary> d_list=data_page.getDataList();
		List<Problemdata> all_list = problemdataService.selectByGroup(null);
		int code1=0,code2=0,code3=0,code4=0,code5=0,code6=0,code7=0,code8=0,code9=0,code10=0,code11=0;
		for (Problemdata rall : all_list) {
			if(d_list!=null&&d_list.size()>0){
				for(int a=0;a<d_list.size();a++){
					problemdata.setDepartmentid(rall.getDepartmentid());
					problemdata.setChapter(d_list.get(a).getCode());
					int tt=problemdataService.countByColum(problemdata);
					switch (d_list.get(a).getCode()) {
					case "001001":
						rall.setCode1(tt);
						code1+=tt;
						break;
					case "001002":
						rall.setCode2(tt);
						code2+=tt;
						break;
					case "001003":
						rall.setCode3(tt);
						code3+=tt;
						break;
					case "001004":
						rall.setCode4(tt);
						code4+=tt;
						break;
					case "001005":
						rall.setCode5(tt);
						code5+=tt;
						break;
					case "001006":
						rall.setCode6(tt);
						code6+=tt;
						break;
					case "001007":
						rall.setCode7(tt);
						code7+=tt;
						break;
					case "001008":
						rall.setCode8(tt);
						code8+=tt;
						break;
					case "001009":
						rall.setCode9(tt);
						code9+=tt;
						break;
					case "001010":
						rall.setCode10(tt);
						code10+=tt;
						break;
					case "001011":
						rall.setCode11(tt);
						code11+=tt;
						break;
					default:
						break;
					}
				}
				
			}
		}
		Problemdata pp = new Problemdata();
		pp.setCode1(code1);
		pp.setCode2(code2);
		pp.setCode3(code3);
		pp.setCode4(code4);
		pp.setCode5(code5);
		pp.setCode6(code6);
		pp.setCode7(code7);
		pp.setCode8(code8);
		pp.setCode9(code9);
		pp.setCode10(code10);
		pp.setCode11(code11);
		pp.setDepartment("合计");
		all_list.add(pp);
		model.put("all_list", all_list);
		if(ext!=null&&ext.equals("ext")){
			return "/backstage/stProbleDataExt";
		}else{
			return "/backstage/stProbleData";
		}
	
	}

}


