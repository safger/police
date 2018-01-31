package com.sn.controller.system;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.namespace.QName;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tempuri.ws_xsd.service.Service;
import org.tempuri.ws_xsd.service.ServicePortType;

import com.alibaba.fastjson.JSON;
import com.hikvision.cms.ws.server.ThirdSdkService;
import com.hikvision.cms.ws.server.ThirdSdkServicePortType;
import com.sn.common.FileUtils;
import com.sn.common.UUIDCreater;
import com.sn.entity.Datadictionary;
import com.sn.entity.MenuRole;
import com.sn.entity.Operating;
import com.sn.entity.Organize;
import com.sn.entity.Pedestrian;
import com.sn.entity.Scope;
import com.sn.entity.Traffic;
import com.sn.service.DatadictionaryService;
import com.sn.service.MenuRoleService;
import com.sn.service.MenuService;
import com.sn.service.OrganizeService;
import com.sn.service.PedestrianService;
import com.sn.service.ScopeService;
import com.sn.service.TrafficService;
import com.sn.service.UserRoleService;
import com.sn.util.PagedResult;

public class CompetenceManager extends HttpServlet {

	/**
	 * 
	 */
	private static final QName SERVICE_NAME = new QName("http://server.ws.cms.hikvision.com", "thirdSdkService");
	private static final long serialVersionUID = 1L;
	public static List<Operating> Operating_list;
	public static List<MenuRole> baseMenuRole_list;
	public static List<Scope> baseScope_list;
	public static List<Organize> baseOrganize_list;
	public MenuRoleService baseMenuRoleService;
	public UserRoleService baseUserRoleService;
	public OrganizeService baseOrganizeService;
	public MenuService baseMenuService;
	public ScopeService baseScopeService;
	public DatadictionaryService baseDatadictionaryService;
	public List<String> or = new ArrayList<String>();
	public WebApplicationContext context;
	private int id;
	private TrafficService trafficService;
	private PedestrianService pedestrianService ;
	/**
	 * 图片存储路径
	 */
	static public String IMAGE_PATH;
	/**
	 * 项目根路径
	 */
	static public String ROOT_PATH;

	public CompetenceManager() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servlet = this.getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		System.out.println("开始缓存时间：" + new Date());
		this.DataRoleMenu(servlet);
		this.DataScope(servlet);
		this.Datadictionary(servlet);
		this.DataOrganize(servlet);

		System.out.println("结束缓存时间：" + new Date());
		//getPerData(servlet);
		//starCars(servlet);
		System.out.println("开始同步数据开始时间：" + new Date());

		System.out.println("开始同步数据结束时间：" + new Date());
		ROOT_PATH = getServletContext().getRealPath("/");
		// 创建路径
		IMAGE_PATH = getServletContext().getRealPath("/") + "/upload/";
		FileUtils.createFilePath(IMAGE_PATH);

	}

	public void starCars(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		// 执行定时器
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// 查询数据库最新一条数据
				id = 280000;
				if (trafficService == null) {
					trafficService = (TrafficService) context.getBean("trafficService");
				}
				PagedResult<Traffic> tr_page = trafficService.findByPage(null, 1, 1, "id desc");
				List<Traffic> tr_list = tr_page.getDataList();
				if (tr_list != null && tr_list.size() > 0) {
					id = tr_list.get(0).getId();
				}
				// 线程处理
				class MyThread extends Thread {
					public void run() {
						try {
							seachCars(trafficService, id);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				MyThread myThread = new MyThread();
				Thread t1 = new Thread(myThread);
				t1.start();

			}
		};
		Timer timer = new Timer();
		long intevalPeriod = 1 * 1800 * 1000; // 半小时小时执行一次
		timer.schedule(task, 0, intevalPeriod);
	}

	public void seachCars(TrafficService trafficService, int id) throws ParseException {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// webservice查询过车记录
			String respData = "<?xml version=\"1.0\" encoding=\" UTF-8\" standalone=\"yes\"?>";
			respData += "<ROOT>";
			respData += "<TSID>" + id + "</TSID>"; 
			respData += "<ZDTS>200</ZDTS>";
			respData += "</ROOT>";
			Service ss = new Service();

			ServicePortType s = ss.getService();
			String returnData = s.getPassVehicleInfos(respData);
			// DOM4J解析XML
			Document document = DocumentHelper.parseText(returnData);
			Element root = document.getRootElement();
			Iterator iter = root.elementIterator("GCXX"); // 获取根节点下的子节点GCXX
			while (iter.hasNext()) {
				Element EL = (Element) iter.next();
				Iterator it2 = EL.elementIterator();
				// 数据库插入
				Traffic traffic = new Traffic();
				traffic.setFuid(UUIDCreater.getUUID());
				traffic.setCreatedate(new Date());
				while (it2.hasNext()) {
					Element EL2 = (Element) it2.next();
					if (EL2.getName() != null && EL2.getName().equals("GCID")) {
						traffic.setId(Integer.parseInt(EL2.getText()));
					}
					if (EL2.getName() != null && EL2.getName().equals("GCSJ")) {
						traffic.setTdate(dateFormat.parse(EL2.getText()));
					}
					if (EL2.getName() != null && EL2.getName().equals("GCCP")) {
						traffic.setLicenseplate(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCCH")) {
						traffic.setCard(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCRT")) {
						traffic.setReadertime(dateFormat.parse(EL2.getText()));
					}
					if (EL2.getName() != null && EL2.getName().equals("GCFX")) {
						traffic.setAccesstype(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCVT")) {
						traffic.setVehicletype(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCVC")) {
						traffic.setVehiclecolor(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCPT")) {
						traffic.setPasstype(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCTP")) {
						traffic.setParktype(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCGN")) {
						traffic.setGateway(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCLN")) {
						traffic.setLanename(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCPI")) {
						traffic.setParkid(Integer.parseInt(EL2.getText()));
					}
					if (EL2.getName() != null && EL2.getName().equals("GCVP")) {
						traffic.setCarimg(EL2.getText());
					}
					if (EL2.getName() != null && EL2.getName().equals("GCPP")) {
						traffic.setBrandimg(EL2.getText());
					}
				}
				trafficService.insert(traffic);
				// 判断最后一个元素
				if (!iter.hasNext()) {
					int newId = traffic.getId();
					// 数据未取完 继续执行
					if (newId - 200 >= id) {
						seachCars(trafficService, newId);
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPerData(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		// 执行定时器
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// 线程处理
				class perThread extends Thread {
					public void run() {
						// 查询最新一条数据
						try {
							if(pedestrianService==null){
								pedestrianService = (PedestrianService) context.getBean("pedestrianService");
							}
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							PagedResult<Pedestrian> p_page = pedestrianService.findByPage(null, 1, 1, " eventtime desc");
							List<Pedestrian> p_list = p_page.getDataList();
							String sdate = "2017-02-24 00:00:00";
							String edate = dateFormat.format(new Date());
							if (p_list != null && p_list.size() > 0) {
								sdate = dateFormat.format(p_list.get(0).getEventtime());
							}
							URL wsdlURL = ThirdSdkService.WSDL_LOCATION;
							ThirdSdkService ss = new ThirdSdkService(wsdlURL, SERVICE_NAME);
							ThirdSdkServicePortType port = ss.getThirdSdkServiceHttpSoap11Endpoint();
							// 登陆用户
							String t = "";
							t += "<root>";
							t += "<userName>xiao</userName>";
							t += "<userPwd>E2F5E798186344470F784F353A80EF7F</userPwd>";
							t += "<ip>10.123.88.9</ip>";
							t += "<port>80</port>";
							t += "</root>";
							String _userLogin__return = port.userLogin(t);
							// 解析登陆获取session
							String sessionId = "";
							Document document = DocumentHelper.parseText(_userLogin__return);
							Element root = document.getRootElement();
							Iterator iter = root.elementIterator("body"); // 获取根节点下的子节点GCXX
							while (iter.hasNext()) {
								Element EL = (Element) iter.next();
								Iterator it2 = EL.elementIterator();
								while (it2.hasNext()) {
									Element EL2 = (Element) it2.next();
									Iterator it3 = EL2.elementIterator();
									while (it3.hasNext()) {
										Element EL3 = (Element) it3.next();
										sessionId = EL3.getText();
									}
								}
							}
							// 查询刷卡记录
							if (sessionId.length() > 0) {
								String st = "";
								st += "<root>";
								st += "<sessionId>" + sessionId + "</sessionId>";
								st += "<beginTime>" + sdate + "</beginTime>";
								st += "<endTime>" + edate + "</endTime>";
								st += "<pageSize>9999</pageSize>";
								st += "<pageIndex>1</pageIndex>";
								st += "</root>";
								String re = port.getAccessEventPage(st);
								Document _document = DocumentHelper.parseText(re);
								Element _root = _document.getRootElement();
								Iterator _iter = _root.elementIterator("body"); // 获取根节点下的子节点GCXX
								while (_iter.hasNext()) {
									Element EL = (Element) _iter.next();
									Iterator it2 = EL.elementIterator();
									while (it2.hasNext()) { 
										Element EL2 = (Element) it2.next();
										if (EL2.getName().equals("items")) {
											Iterator it3 = EL2.elementIterator();
											while (it3.hasNext()) {
												Element EL3 = (Element) it3.next();
												Iterator it4 = EL3.elementIterator();
												// 插入数据库
												Pedestrian per = new Pedestrian();
												per.setFuid(UUIDCreater.getUUID());
												per.setCreatedate(new Date());
												String etime = "";
												int perid = 0;
												while (it4.hasNext()) {
													Element EL4 = (Element) it4.next();
													if (EL4.getName().equals("eventTime")) {
														etime = EL4.getText();
														per.setEventtime(dateFormat.parse(etime));
													}
													if (EL4.getName().equals("eventName")) {
														per.setEventname(EL4.getText());
													}
													if (EL4.getName().equals("eventCard")) {
														per.setCard(EL4.getText());
													}
													if (EL4.getName().equals("personId")) {
														if(EL4.getText().trim().length()>0){
															try {
																perid = Integer.parseInt(EL4.getText());
															} catch (Exception e) {
																// TODO: handle exception
															}
														}
														per.setPersonid(perid);
													}
													if (EL4.getName().equals("personName")) {
														per.setPersonname(EL4.getText());
													}
													if (EL4.getName().equals("deptId")) {
														per.setDeptid(EL4.getText());
													}
													if (EL4.getName().equals("deptName")) {
														per.setDeptname(EL4.getText());
													}
													if (EL4.getName().equals("deptCode")) {
														per.setDeptcode(EL4.getText());
													}
													if (EL4.getName().equals("doorName")) {
														per.setDoorname(EL4.getText());
													}
													if (EL4.getName().equals("deviceName")) {
														per.setDevicename(EL4.getText());
													}
												}
												if (perid != 0 && etime.length() > 0) {
													pedestrianService.insertSelective(per);
												}
											}
										}

									}

								}
							}

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DocumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				perThread myThread = new perThread();
				Thread t1 = new Thread(myThread);
				t1.start();

			} 
		};
		Timer timer = new Timer();
		long intevalPeriod = 1 * 1800 * 1000; // 半小时小时执行一次
		timer.schedule(task, 0, intevalPeriod);

	}
	public void DataScope(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseScopeService = (ScopeService) context.getBean("scopeService");
		baseScope_list = baseScopeService.selectScope();
	}

	public void DataOrganize(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseOrganizeService = (OrganizeService) context.getBean("organizeService");
		baseOrganize_list = baseOrganizeService.selectByColum(null, null);
	}

	public void DataRoleMenu(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseMenuRoleService = (MenuRoleService) context.getBean("menuRoleService");
		baseMenuRole_list = baseMenuRoleService.selectMenuOp();
	}

	public void Datadictionary(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseDatadictionaryService = (DatadictionaryService) context.getBean("datadictionaryService");
		List<Datadictionary> baseDatadictionary_list = baseDatadictionaryService.selectByColum(null, " sequence");
		Map<String, String> DatadictionaryMap = new HashMap<String, String>();
		for (Datadictionary t : baseDatadictionary_list) {
			DatadictionaryMap.put(t.getCode().toString(), t.getFullname());
		}

		servlet.setAttribute("DatadictionaryMap", DatadictionaryMap);
		servlet.setAttribute("baseDatadictionary_list", JSON.toJSONString(baseDatadictionary_list));
	}

	/**
	 * @see 获取操作权限
	 * @param roleid
	 * @param menuid
	 * @return
	 */
	public static ComData getCom(String roleid, String menuid) {
		String ro[] = null;
		if (roleid != null && roleid.length() > 0) {
			ro = roleid.split(",");
		}
		ComData com = new ComData();
		if (baseMenuRole_list != null) {
			for (int a = 0; a < baseMenuRole_list.size(); a++) {
				if (ro != null) {
					for (int b = 0; b < ro.length; b++) {
						if (baseMenuRole_list.get(a).getMenuId() != null && baseMenuRole_list.get(a).getMenuId().equals(menuid) && baseMenuRole_list.get(a).getRoleId() != null && baseMenuRole_list.get(a).getRoleId().equals(ro[b])) {
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_show")) {
								com.setHisSelect(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_add")) {
								com.setHisAdd(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_del")) {
								com.setHisDelete(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_update")) {
								com.setHisUpdate(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().startsWith("bu")) {
								com.getHisOther().put(baseMenuRole_list.get(a).getOperatingId(), true);
							}

						}
					}
				}
			}
		}
		System.out.println(menuid + "-----add:" + com.getHisAdd());
		System.out.println(menuid + "-----del:" + com.getHisDelete());
		System.out.println(menuid + "-----sel:" + com.getHisSelect());
		System.out.println(menuid + "-----update:" + com.getHisUpdate());
		return com;
	}

	/**
	 * @see 根据地址获取数据集权限
	 * @param MenuUrl
	 * @param RoleId
	 * @return
	 */
	public static String getScope(String MenuUrl, String RoleId) {
		String OrganizeId = "";
		if (baseScope_list != null && baseScope_list.size() > 0) {
			for (int a = 0; a < baseScope_list.size(); a++) {
				String menu_url = baseScope_list.get(a).getMenuId();
				String role_id = baseScope_list.get(a).getRoleId();
				if (menu_url != null && menu_url.equals(MenuUrl) && role_id != null && role_id.equals(RoleId)) {
					OrganizeId += "'" + baseScope_list.get(a).getOrganizeId() + "',";
				}
			}

		}
		OrganizeId = OrganizeId.length() > 0 ? OrganizeId.substring(0, OrganizeId.length() - 1) : OrganizeId;
		return OrganizeId;
	}

	/**
	 * @see 获取子部门系统
	 * @param OrganizeId
	 * @return
	 */
	public String getOrganizeChild(String OrganizeId) {
		if (baseOrganize_list != null && baseOrganize_list.size() > 0) {
			for (int a = 0; a < baseOrganize_list.size(); a++) {
				if (baseOrganize_list.get(a).getParentid().equals(OrganizeId)) {
					or.add(baseOrganize_list.get(a).getFuid());
					getOrganizeChild(baseOrganize_list.get(a).getFuid());
				}
			}
		}
		String Organize_Id = "";
		if (or != null && or.size() > 0) {
			for (int a = 0; a < or.size(); a++) {
				Organize_Id += "'" + or.get(a) + "',";
			}
		}
		Organize_Id = Organize_Id.length() > 0 ? Organize_Id.substring(0, Organize_Id.length() - 1) : "'" + OrganizeId + "'";
		Organize_Id += ",'" + OrganizeId + "'";
		return Organize_Id;
	}




	public void refreshRoleMenu(ServletContext servlet) {
		this.DataRoleMenu(servlet);
	}

	public void RefreshDatadictionary(ServletContext servlet) {
		this.Datadictionary(servlet);
	}

	public void RefreshDataScope(ServletContext servlet) {
		this.DataScope(servlet);
	}

	public void RefreshDataOrganize(ServletContext servlet) {
		this.DataOrganize(servlet);
	}

	public void clear() {
		baseMenuRole_list = null;
	}

	public List<String> getOr() {
		return or;
	}

	public void setOr(List<String> or) {
		this.or = or;
	}

	public static List<Operating> getOperating_list() {
		return Operating_list;
	}

	public static void setOperating_list(List<Operating> operating_list) {
		Operating_list = operating_list;
	}

	public static List<MenuRole> getBaseMenuRole_list() {
		return baseMenuRole_list;
	}

	public static void setBaseMenuRole_list(List<MenuRole> baseMenuRole_list) {
		CompetenceManager.baseMenuRole_list = baseMenuRole_list;
	}

	public static List<Scope> getBaseScope_list() {
		return baseScope_list;
	}

	public static void setBaseScope_list(List<Scope> baseScope_list) {
		CompetenceManager.baseScope_list = baseScope_list;
	}

	public static List<Organize> getBaseOrganize_list() {
		return baseOrganize_list;
	}

	public static void setBaseOrganize_list(List<Organize> baseOrganize_list) {
		CompetenceManager.baseOrganize_list = baseOrganize_list;
	}

	public MenuRoleService getBaseMenuRoleService() {
		return baseMenuRoleService;
	}

	public void setBaseMenuRoleService(MenuRoleService baseMenuRoleService) {
		this.baseMenuRoleService = baseMenuRoleService;
	}

	public UserRoleService getBaseUserRoleService() {
		return baseUserRoleService;
	}

	public void setBaseUserRoleService(UserRoleService baseUserRoleService) {
		this.baseUserRoleService = baseUserRoleService;
	}

	public OrganizeService getBaseOrganizeService() {
		return baseOrganizeService;
	}

	public void setBaseOrganizeService(OrganizeService baseOrganizeService) {
		this.baseOrganizeService = baseOrganizeService;
	}

	public MenuService getBaseMenuService() {
		return baseMenuService;
	}

	public void setBaseMenuService(MenuService baseMenuService) {
		this.baseMenuService = baseMenuService;
	}

	public ScopeService getBaseScopeService() {
		return baseScopeService;
	}

	public void setBaseScopeService(ScopeService baseScopeService) {
		this.baseScopeService = baseScopeService;
	}

	public DatadictionaryService getBaseDatadictionaryService() {
		return baseDatadictionaryService;
	}

	public void setBaseDatadictionaryService(DatadictionaryService baseDatadictionaryService) {
		this.baseDatadictionaryService = baseDatadictionaryService;
	}

	public static String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public static void setIMAGE_PATH(String iMAGE_PATH) {
		IMAGE_PATH = iMAGE_PATH;
	}

	public static String getROOT_PATH() {
		return ROOT_PATH;
	}

	public static void setROOT_PATH(String rOOT_PATH) {
		ROOT_PATH = rOOT_PATH;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
