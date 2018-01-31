package com.sn.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.tempuri.ws_xsd.service.Service;
import org.tempuri.ws_xsd.service.ServicePortType;

import com.alibaba.fastjson.JSONArray;
import com.sn.entity.echarts;

public class UUIDCreater {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	public static String test() {
		return "12312";
	}

	public static void main(String[] args) throws Exception {
		String tt="<?xml version=\"1.0\" encoding=\" UTF-8\" standalone=\"yes\"?>";
		tt+="<ROOT>"; 	
		tt+="<TSID>280000</TSID>"; 	
		tt+="<ZDTS>2</ZDTS>"; 	
		tt+="</ROOT>"; 	
		System.out.println(tt);
		Service ss=new Service();
		 
		ServicePortType s=ss.getService();
		System.out.println(s.getPassVehicleInfos(tt));
		
	}
}