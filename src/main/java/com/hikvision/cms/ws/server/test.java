package com.hikvision.cms.ws.server;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.namespace.QName;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class test {
	 private static final QName SERVICE_NAME = new QName("http://server.ws.cms.hikvision.com", "thirdSdkService");
	public static void main(String[] args) throws NoSuchAlgorithmException, DocumentException {
		// TODO Auto-generated method stub
		
		/*MessageDigest md5=MessageDigest.getInstance("MD5");
		md5.update(ps.getBytes());
		String pp=new BigInteger(1,md5.digest()).toString(16);
		System.out.println(new BigInteger(1,md5.digest()).toString(16));*/
		
	       // String re=port.getRecordResultPage(st);
	      //  System.out.println(re);
	      /*  String st1="";
	        st1+="<root>";
	        st1+="<sessionId>"+sessionid+"</sessionId>";
	        st1+="<pageSize>10</pageSize>";
	        st1+="<pageIndex>1</pageIndex>";
	        st1+="</root>";
	        
	        System.out.println(port.getPersonAndCards(st1));*/
	      /*  String st1="";
	        st1+="<root>";
	        st1+="<sessionId>"+sessionid+"</sessionId>";
	        st1+="<deptCode>0000</deptCode>";
	        st1+="<contentChr>1</contentChr>";
	        st1+="</root>";
	        System.out.println(port.getDepartments(st1));*/
	        //登陆信息
	       String _userLogin__return="<root><head><errorCode>0</errorCode><result>true</result></head><body><total>2772</total><totalPage>1386</totalPage><pageIndex>1</pageIndex><pageSize>2</pageSize><items><item><acEventId>C8578424CB654E2DB9229BA4356E3C6E</acEventId><eventType>198914</eventType><eventTime>2017-02-23 12:00:32</eventTime><eventName>合法卡比对通过</eventName><eventCode>83886337</eventCode><eventCard>1931600606</eventCard><personId>1511</personId><personName>卢泓丞</personName><deptId>1</deptId><deptName>默认部门</deptName><deptCode>0000</deptCode><deviceId>5</deviceId><deviceName>出门读卡器_2</deviceName><deviceType>202059776</deviceType><doorId>2</doorId><doorName>大门翼闸_门2</doorName><devicel1Id>1</devicel1Id><devicel1Name>大门翼闸</devicel1Name><devicel1Type>201926400</devicel1Type><devicel2Id>0</devicel2Id><devicel2Name></devicel2Name><devicel2Type>0</devicel2Type><devicel3Id>5</devicel3Id><devicel3Name>出门读卡器_2</devicel3Name><devicel3Type>202059776</devicel3Type><regionId/><regionName/><controlUnitId/><controlUnitName/><tag/><systemType/><systemName/><state>0</state><triggerRecord/><remark></remark></item><item><acEventId>C06B1835F4FF465E8602F7FA64ADEFE3</acEventId><eventType>199941</eventType><eventTime>2017-02-23 12:00:32</eventTime><eventName>门锁打开</eventName><eventCode>83891456</eventCode><eventCard/><personId>0</personId><personName></personName><deptId>0</deptId><deptName></deptName><deptCode></deptCode><deviceId>0</deviceId><deviceName></deviceName><deviceType>0</deviceType><doorId>2</doorId><doorName>大门翼闸_门2</doorName><devicel1Id>1</devicel1Id><devicel1Name>大门翼闸</devicel1Name><devicel1Type>201926400</devicel1Type><devicel2Id>0</devicel2Id><devicel2Name></devicel2Name><devicel2Type>0</devicel2Type><devicel3Id>0</devicel3Id><devicel3Name></devicel3Name><devicel3Type>0</devicel3Type><regionId/><regionName/><controlUnitId/><controlUnitName/><tag/><systemType/><systemName/><state>0</state><triggerRecord/><remark></remark></item></items></body></root>";
	       	Document  document = DocumentHelper.parseText(_userLogin__return);
		     Element root = document.getRootElement();
	 		 Iterator iter = root.elementIterator("body"); // 获取根节点下的子节点GCXX
	 		 while (iter.hasNext()) {
	 			  Element EL = (Element) iter.next(); 
	 				 Iterator it2 = EL.elementIterator(); 
		 			  while (it2.hasNext()) {
		 				  Element EL2 = (Element) it2.next(); 
		 				 if(EL2.getName().equals("items")){
			 				  Iterator it3 = EL2.elementIterator(); 
			 				  while (it3.hasNext()) {
			 					  Element EL3 = (Element) it3.next(); 
			 					 Iterator it4 = EL3.elementIterator();
			 					 while (it4.hasNext()) {
			 						Element EL4 = (Element) it4.next(); 
			 						System.out.println(EL4.getName());
			 					 }
			 					  
			 				  }
			 				}
		 				
		 			  }
	 			  
	 		  }
    		  
	}

}
