package org.tempuri.ws_xsd.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "ServicePortType", targetNamespace = "http://tempuri.org/ws.xsd/Service.wsdl")
public interface ServicePortType {

	/**
	 * Service definition of function ws__GetParkingInfos
	 * 
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "GetParkingInfos")
	@WebResult(name = "respond", targetNamespace = "")
	@RequestWrapper(localName = "GetParkingInfos", targetNamespace = "http://tempuri.org/ws.xsd", className = "org.tempuri.ws.GetParkingInfos")
	@ResponseWrapper(localName = "GetParkingInfosResponse", targetNamespace = "http://tempuri.org/ws.xsd", className = "org.tempuri.ws.GetParkingInfosResponse")
	public String getParkingInfos();

	/**
	 * Service definition of function ws__GetPassVehicleInfos
	 * 
	 * @param condition
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "GetPassVehicleInfos")
	@WebResult(name = "respond", targetNamespace = "")
	@RequestWrapper(localName = "GetPassVehicleInfos", targetNamespace = "http://tempuri.org/ws.xsd", className = "org.tempuri.ws.GetPassVehicleInfos")
	@ResponseWrapper(localName = "GetPassVehicleInfosResponse", targetNamespace = "http://tempuri.org/ws.xsd", className = "org.tempuri.ws.GetPassVehicleInfosResponse")
	public String getPassVehicleInfos(@WebParam(name = "condition", targetNamespace = "") String condition);

	/**
	 * Service definition of function ws__GetPayInfos
	 * 
	 * @param condition
	 * @return returns java.lang.String
	 */
	@WebMethod(operationName = "GetPayInfos")
	@WebResult(name = "respond", targetNamespace = "")
	@RequestWrapper(localName = "GetPayInfos", targetNamespace = "http://tempuri.org/ws.xsd", className = "org.tempuri.ws.GetPayInfos")
	@ResponseWrapper(localName = "GetPayInfosResponse", targetNamespace = "http://tempuri.org/ws.xsd", className = "org.tempuri.ws.GetPayInfosResponse")
	public String getPayInfos(@WebParam(name = "condition", targetNamespace = "") String condition);

}
