package com.hikvision.cms.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-02-24T10:01:06.794+08:00
 * Generated source version: 3.1.10
 * 
 */
@WebService(targetNamespace = "http://server.ws.cms.hikvision.com", name = "thirdSdkServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface ThirdSdkServicePortType {

    @WebMethod(action = "urn:userLogin")
    @Action(input = "urn:userLogin", output = "urn:userLoginResponse")
    @RequestWrapper(localName = "userLogin", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UserLogin")
    @ResponseWrapper(localName = "userLoginResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UserLoginResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String userLogin(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAccessDoorRegionNotNullPage")
    @Action(input = "urn:getAccessDoorRegionNotNullPage", output = "urn:getAccessDoorRegionNotNullPageResponse")
    @RequestWrapper(localName = "getAccessDoorRegionNotNullPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessDoorRegionNotNullPage")
    @ResponseWrapper(localName = "getAccessDoorRegionNotNullPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessDoorRegionNotNullPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAccessDoorRegionNotNullPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getPMSUrl")
    @Action(input = "urn:getPMSUrl", output = "urn:getPMSUrlResponse")
    @RequestWrapper(localName = "getPMSUrl", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPMSUrl")
    @ResponseWrapper(localName = "getPMSUrlResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPMSUrlResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPMSUrl(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAccessControlPage")
    @Action(input = "urn:getAccessControlPage", output = "urn:getAccessControlPageResponse")
    @RequestWrapper(localName = "getAccessControlPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessControlPage")
    @ResponseWrapper(localName = "getAccessControlPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessControlPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAccessControlPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:saveOrUpdateOpsThirdDevice")
    @Action(input = "urn:saveOrUpdateOpsThirdDevice", output = "urn:saveOrUpdateOpsThirdDeviceResponse")
    @RequestWrapper(localName = "saveOrUpdateOpsThirdDevice", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.SaveOrUpdateOpsThirdDevice")
    @ResponseWrapper(localName = "saveOrUpdateOpsThirdDeviceResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.SaveOrUpdateOpsThirdDeviceResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String saveOrUpdateOpsThirdDevice(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getClockRecordPage")
    @Action(input = "urn:getClockRecordPage", output = "urn:getClockRecordPageResponse")
    @RequestWrapper(localName = "getClockRecordPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetClockRecordPage")
    @ResponseWrapper(localName = "getClockRecordPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetClockRecordPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getClockRecordPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAllOpsThirdDevice")
    @Action(input = "urn:getAllOpsThirdDevice", output = "urn:getAllOpsThirdDeviceResponse")
    @RequestWrapper(localName = "getAllOpsThirdDevice", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllOpsThirdDevice")
    @ResponseWrapper(localName = "getAllOpsThirdDeviceResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllOpsThirdDeviceResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAllOpsThirdDevice(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:updateUser")
    @Action(input = "urn:updateUser", output = "urn:updateUserResponse")
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UpdateUserResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String updateUser(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getRecordResultPage")
    @Action(input = "urn:getRecordResultPage", output = "urn:getRecordResultPageResponse")
    @RequestWrapper(localName = "getRecordResultPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetRecordResultPage")
    @ResponseWrapper(localName = "getRecordResultPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetRecordResultPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getRecordResultPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getProgramPage")
    @Action(input = "urn:getProgramPage", output = "urn:getProgramPageResponse")
    @RequestWrapper(localName = "getProgramPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetProgramPage")
    @ResponseWrapper(localName = "getProgramPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetProgramPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getProgramPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAllServer")
    @Action(input = "urn:getAllServer", output = "urn:getAllServerResponse")
    @RequestWrapper(localName = "getAllServer", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllServer")
    @ResponseWrapper(localName = "getAllServerResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllServerResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAllServer(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAllRouteAndPointInfo")
    @Action(input = "urn:getAllRouteAndPointInfo", output = "urn:getAllRouteAndPointInfoResponse")
    @RequestWrapper(localName = "getAllRouteAndPointInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllRouteAndPointInfo")
    @ResponseWrapper(localName = "getAllRouteAndPointInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllRouteAndPointInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAllRouteAndPointInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:filterControlUnitId")
    @Action(input = "urn:filterControlUnitId", output = "urn:filterControlUnitIdResponse")
    @RequestWrapper(localName = "filterControlUnitId", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.FilterControlUnitId")
    @ResponseWrapper(localName = "filterControlUnitIdResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.FilterControlUnitIdResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.util.List<java.lang.Integer> filterControlUnitId(
        @WebParam(name = "controlUnitIds", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.util.List<java.lang.Integer> controlUnitIds,
        @WebParam(name = "userId", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.Integer userId
    );

    @WebMethod(action = "urn:getPrivilegeResult")
    @Action(input = "urn:getPrivilegeResult", output = "urn:getPrivilegeResultResponse")
    @RequestWrapper(localName = "getPrivilegeResult", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPrivilegeResult")
    @ResponseWrapper(localName = "getPrivilegeResultResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPrivilegeResultResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPrivilegeResult(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAccessControlByUserNamePage")
    @Action(input = "urn:getAccessControlByUserNamePage", output = "urn:getAccessControlByUserNamePageResponse")
    @RequestWrapper(localName = "getAccessControlByUserNamePage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessControlByUserNamePage")
    @ResponseWrapper(localName = "getAccessControlByUserNamePageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessControlByUserNamePageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAccessControlByUserNamePage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getGateInfo")
    @Action(input = "urn:getGateInfo", output = "urn:getGateInfoResponse")
    @RequestWrapper(localName = "getGateInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetGateInfo")
    @ResponseWrapper(localName = "getGateInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetGateInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getGateInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getPresons")
    @Action(input = "urn:getPresons", output = "urn:getPresonsResponse")
    @RequestWrapper(localName = "getPresons", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPresons")
    @ResponseWrapper(localName = "getPresonsResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPresonsResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPresons(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getCardsPageResult")
    @Action(input = "urn:getCardsPageResult", output = "urn:getCardsPageResultResponse")
    @RequestWrapper(localName = "getCardsPageResult", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetCardsPageResult")
    @ResponseWrapper(localName = "getCardsPageResultResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetCardsPageResultResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getCardsPageResult(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getEncoderInfo")
    @Action(input = "urn:getEncoderInfo", output = "urn:getEncoderInfoResponse")
    @RequestWrapper(localName = "getEncoderInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetEncoderInfo")
    @ResponseWrapper(localName = "getEncoderInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetEncoderInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getEncoderInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getDeviceStatus")
    @Action(input = "urn:getDeviceStatus", output = "urn:getDeviceStatusResponse")
    @RequestWrapper(localName = "getDeviceStatus", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetDeviceStatus")
    @ResponseWrapper(localName = "getDeviceStatusResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetDeviceStatusResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getDeviceStatus(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAlarmChannel")
    @Action(input = "urn:getAlarmChannel", output = "urn:getAlarmChannelResponse")
    @RequestWrapper(localName = "getAlarmChannel", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAlarmChannel")
    @ResponseWrapper(localName = "getAlarmChannelResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAlarmChannelResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAlarmChannel(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getPassCarsCounting")
    @Action(input = "urn:getPassCarsCounting", output = "urn:getPassCarsCountingResponse")
    @RequestWrapper(localName = "getPassCarsCounting", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPassCarsCounting")
    @ResponseWrapper(localName = "getPassCarsCountingResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPassCarsCountingResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPassCarsCounting(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAlarmEventPage")
    @Action(input = "urn:getAlarmEventPage", output = "urn:getAlarmEventPageResponse")
    @RequestWrapper(localName = "getAlarmEventPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAlarmEventPage")
    @ResponseWrapper(localName = "getAlarmEventPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAlarmEventPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAlarmEventPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getIoPage")
    @Action(input = "urn:getIoPage", output = "urn:getIoPageResponse")
    @RequestWrapper(localName = "getIoPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetIoPage")
    @ResponseWrapper(localName = "getIoPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetIoPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getIoPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getPersonAndCards")
    @Action(input = "urn:getPersonAndCards", output = "urn:getPersonAndCardsResponse")
    @RequestWrapper(localName = "getPersonAndCards", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPersonAndCards")
    @ResponseWrapper(localName = "getPersonAndCardsResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPersonAndCardsResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPersonAndCards(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:importPersonAndCardInfo")
    @Action(input = "urn:importPersonAndCardInfo", output = "urn:importPersonAndCardInfoResponse")
    @RequestWrapper(localName = "importPersonAndCardInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.ImportPersonAndCardInfo")
    @ResponseWrapper(localName = "importPersonAndCardInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.ImportPersonAndCardInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String importPersonAndCardInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getDepartments")
    @Action(input = "urn:getDepartments", output = "urn:getDepartmentsResponse")
    @RequestWrapper(localName = "getDepartments", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetDepartments")
    @ResponseWrapper(localName = "getDepartmentsResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetDepartmentsResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getDepartments(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAccessDoorPage")
    @Action(input = "urn:getAccessDoorPage", output = "urn:getAccessDoorPageResponse")
    @RequestWrapper(localName = "getAccessDoorPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessDoorPage")
    @ResponseWrapper(localName = "getAccessDoorPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessDoorPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAccessDoorPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:deleteUser")
    @Action(input = "urn:deleteUser", output = "urn:deleteUserResponse")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.DeleteUserResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String deleteUser(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:userLogOut")
    @Action(input = "urn:userLogOut", output = "urn:userLogOutResponse")
    @RequestWrapper(localName = "userLogOut", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UserLogOut")
    @ResponseWrapper(localName = "userLogOutResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UserLogOutResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String userLogOut(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getControlUnitInfo")
    @Action(input = "urn:getControlUnitInfo", output = "urn:getControlUnitInfoResponse")
    @RequestWrapper(localName = "getControlUnitInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetControlUnitInfo")
    @ResponseWrapper(localName = "getControlUnitInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetControlUnitInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getControlUnitInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getCameraInfo")
    @Action(input = "urn:getCameraInfo", output = "urn:getCameraInfoResponse")
    @RequestWrapper(localName = "getCameraInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetCameraInfo")
    @ResponseWrapper(localName = "getCameraInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetCameraInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getCameraInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getRoutePage")
    @Action(input = "urn:getRoutePage", output = "urn:getRoutePageResponse")
    @RequestWrapper(localName = "getRoutePage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetRoutePage")
    @ResponseWrapper(localName = "getRoutePageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetRoutePageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getRoutePage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAllPersonInspectionResult")
    @Action(input = "urn:getAllPersonInspectionResult", output = "urn:getAllPersonInspectionResultResponse")
    @RequestWrapper(localName = "getAllPersonInspectionResult", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllPersonInspectionResult")
    @ResponseWrapper(localName = "getAllPersonInspectionResultResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllPersonInspectionResultResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAllPersonInspectionResult(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:userOnlineHearbeat")
    @Action(input = "urn:userOnlineHearbeat", output = "urn:userOnlineHearbeatResponse")
    @RequestWrapper(localName = "userOnlineHearbeat", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UserOnlineHearbeat")
    @ResponseWrapper(localName = "userOnlineHearbeatResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.UserOnlineHearbeatResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String userOnlineHearbeat(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getSchedulingHistoryPage")
    @Action(input = "urn:getSchedulingHistoryPage", output = "urn:getSchedulingHistoryPageResponse")
    @RequestWrapper(localName = "getSchedulingHistoryPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetSchedulingHistoryPage")
    @ResponseWrapper(localName = "getSchedulingHistoryPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetSchedulingHistoryPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getSchedulingHistoryPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getPassCarsInfo")
    @Action(input = "urn:getPassCarsInfo", output = "urn:getPassCarsInfoResponse")
    @RequestWrapper(localName = "getPassCarsInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPassCarsInfo")
    @ResponseWrapper(localName = "getPassCarsInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPassCarsInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPassCarsInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getPTZSeizeTime")
    @Action(input = "urn:getPTZSeizeTime", output = "urn:getPTZSeizeTimeResponse")
    @RequestWrapper(localName = "getPTZSeizeTime", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPTZSeizeTime")
    @ResponseWrapper(localName = "getPTZSeizeTimeResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetPTZSeizeTimeResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getPTZSeizeTime(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getParkingInfo")
    @Action(input = "urn:getParkingInfo", output = "urn:getParkingInfoResponse")
    @RequestWrapper(localName = "getParkingInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetParkingInfo")
    @ResponseWrapper(localName = "getParkingInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetParkingInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getParkingInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getEcsControlPage")
    @Action(input = "urn:getEcsControlPage", output = "urn:getEcsControlPageResponse")
    @RequestWrapper(localName = "getEcsControlPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetEcsControlPage")
    @ResponseWrapper(localName = "getEcsControlPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetEcsControlPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getEcsControlPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getParkingRegions")
    @Action(input = "urn:getParkingRegions", output = "urn:getParkingRegionsResponse")
    @RequestWrapper(localName = "getParkingRegions", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetParkingRegions")
    @ResponseWrapper(localName = "getParkingRegionsResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetParkingRegionsResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getParkingRegions(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:covertListToString")
    @Action(input = "urn:covertListToString", output = "urn:covertListToStringResponse")
    @RequestWrapper(localName = "covertListToString", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.CovertListToString")
    @ResponseWrapper(localName = "covertListToStringResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.CovertListToStringResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String covertListToString(
        @WebParam(name = "list", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.util.List<java.lang.String> list
    );

    @WebMethod(action = "urn:getAccessEventPage")
    @Action(input = "urn:getAccessEventPage", output = "urn:getAccessEventPageResponse")
    @RequestWrapper(localName = "getAccessEventPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessEventPage")
    @ResponseWrapper(localName = "getAccessEventPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAccessEventPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAccessEventPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:doControl")
    @Action(input = "urn:doControl", output = "urn:doControlResponse")
    @RequestWrapper(localName = "doControl", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.DoControl")
    @ResponseWrapper(localName = "doControlResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.DoControlResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String doControl(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAllAlarmState")
    @Action(input = "urn:getAllAlarmState", output = "urn:getAllAlarmStateResponse")
    @RequestWrapper(localName = "getAllAlarmState", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllAlarmState")
    @ResponseWrapper(localName = "getAllAlarmStateResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAllAlarmStateResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAllAlarmState(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getCameraPreviewUrl")
    @Action(input = "urn:getCameraPreviewUrl", output = "urn:getCameraPreviewUrlResponse")
    @RequestWrapper(localName = "getCameraPreviewUrl", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetCameraPreviewUrl")
    @ResponseWrapper(localName = "getCameraPreviewUrlResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetCameraPreviewUrlResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getCameraPreviewUrl(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:addUser")
    @Action(input = "urn:addUser", output = "urn:addUserResponse")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.AddUserResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String addUser(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:deleteOpsThirdDeviceBySysCode")
    @Action(input = "urn:deleteOpsThirdDeviceBySysCode", output = "urn:deleteOpsThirdDeviceBySysCodeResponse")
    @RequestWrapper(localName = "deleteOpsThirdDeviceBySysCode", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.DeleteOpsThirdDeviceBySysCode")
    @ResponseWrapper(localName = "deleteOpsThirdDeviceBySysCodeResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.DeleteOpsThirdDeviceBySysCodeResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String deleteOpsThirdDeviceBySysCode(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getAlarmDeviceInfo")
    @Action(input = "urn:getAlarmDeviceInfo", output = "urn:getAlarmDeviceInfoResponse")
    @RequestWrapper(localName = "getAlarmDeviceInfo", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAlarmDeviceInfo")
    @ResponseWrapper(localName = "getAlarmDeviceInfoResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetAlarmDeviceInfoResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getAlarmDeviceInfo(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );

    @WebMethod(action = "urn:getSchedulingPage")
    @Action(input = "urn:getSchedulingPage", output = "urn:getSchedulingPageResponse")
    @RequestWrapper(localName = "getSchedulingPage", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetSchedulingPage")
    @ResponseWrapper(localName = "getSchedulingPageResponse", targetNamespace = "http://server.ws.cms.hikvision.com", className = "com.hikvision.cms.ws.server.GetSchedulingPageResponse")
    @WebResult(name = "return", targetNamespace = "http://server.ws.cms.hikvision.com")
    public java.lang.String getSchedulingPage(
        @WebParam(name = "xml", targetNamespace = "http://server.ws.cms.hikvision.com")
        java.lang.String xml
    );
}
