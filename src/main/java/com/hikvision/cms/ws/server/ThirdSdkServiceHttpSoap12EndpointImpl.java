
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.hikvision.cms.ws.server;

import java.util.logging.Logger;
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
 * 2017-02-24T10:01:06.773+08:00
 * Generated source version: 3.1.10
 * 
 */

@javax.jws.WebService(
                      serviceName = "thirdSdkService",
                      portName = "thirdSdkServiceHttpSoap12Endpoint",
                      targetNamespace = "http://server.ws.cms.hikvision.com",
                      wsdlLocation = "http://10.123.115.67/services/thirdSdkService?wsdl",
                      endpointInterface = "com.hikvision.cms.ws.server.ThirdSdkServicePortType")
                      
public class ThirdSdkServiceHttpSoap12EndpointImpl implements ThirdSdkServicePortType {

    private static final Logger LOG = Logger.getLogger(ThirdSdkServiceHttpSoap12EndpointImpl.class.getName());

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#userLogin(java.lang.String xml)*
     */
    public java.lang.String userLogin(java.lang.String xml) { 
        LOG.info("Executing operation userLogin");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAccessDoorRegionNotNullPage(java.lang.String xml)*
     */
    public java.lang.String getAccessDoorRegionNotNullPage(java.lang.String xml) { 
        LOG.info("Executing operation getAccessDoorRegionNotNullPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPMSUrl(java.lang.String xml)*
     */
    public java.lang.String getPMSUrl(java.lang.String xml) { 
        LOG.info("Executing operation getPMSUrl");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAccessControlPage(java.lang.String xml)*
     */
    public java.lang.String getAccessControlPage(java.lang.String xml) { 
        LOG.info("Executing operation getAccessControlPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#saveOrUpdateOpsThirdDevice(java.lang.String xml)*
     */
    public java.lang.String saveOrUpdateOpsThirdDevice(java.lang.String xml) { 
        LOG.info("Executing operation saveOrUpdateOpsThirdDevice");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getClockRecordPage(java.lang.String xml)*
     */
    public java.lang.String getClockRecordPage(java.lang.String xml) { 
        LOG.info("Executing operation getClockRecordPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAllOpsThirdDevice(java.lang.String xml)*
     */
    public java.lang.String getAllOpsThirdDevice(java.lang.String xml) { 
        LOG.info("Executing operation getAllOpsThirdDevice");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#updateUser(java.lang.String xml)*
     */
    public java.lang.String updateUser(java.lang.String xml) { 
        LOG.info("Executing operation updateUser");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getRecordResultPage(java.lang.String xml)*
     */
    public java.lang.String getRecordResultPage(java.lang.String xml) { 
        LOG.info("Executing operation getRecordResultPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getProgramPage(java.lang.String xml)*
     */
    public java.lang.String getProgramPage(java.lang.String xml) { 
        LOG.info("Executing operation getProgramPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAllServer(java.lang.String xml)*
     */
    public java.lang.String getAllServer(java.lang.String xml) { 
        LOG.info("Executing operation getAllServer");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAllRouteAndPointInfo(java.lang.String xml)*
     */
    public java.lang.String getAllRouteAndPointInfo(java.lang.String xml) { 
        LOG.info("Executing operation getAllRouteAndPointInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#filterControlUnitId(java.util.List<java.lang.Integer> controlUnitIds, java.lang.Integer userId)*
     */
    public java.util.List<java.lang.Integer> filterControlUnitId(java.util.List<java.lang.Integer> controlUnitIds, java.lang.Integer userId) { 
        LOG.info("Executing operation filterControlUnitId");
        System.out.println(controlUnitIds);
        System.out.println(userId);
        try {
            java.util.List<java.lang.Integer> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPrivilegeResult(java.lang.String xml)*
     */
    public java.lang.String getPrivilegeResult(java.lang.String xml) { 
        LOG.info("Executing operation getPrivilegeResult");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAccessControlByUserNamePage(java.lang.String xml)*
     */
    public java.lang.String getAccessControlByUserNamePage(java.lang.String xml) { 
        LOG.info("Executing operation getAccessControlByUserNamePage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getGateInfo(java.lang.String xml)*
     */
    public java.lang.String getGateInfo(java.lang.String xml) { 
        LOG.info("Executing operation getGateInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPresons(java.lang.String xml)*
     */
    public java.lang.String getPresons(java.lang.String xml) { 
        LOG.info("Executing operation getPresons");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getCardsPageResult(java.lang.String xml)*
     */
    public java.lang.String getCardsPageResult(java.lang.String xml) { 
        LOG.info("Executing operation getCardsPageResult");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getEncoderInfo(java.lang.String xml)*
     */
    public java.lang.String getEncoderInfo(java.lang.String xml) { 
        LOG.info("Executing operation getEncoderInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getDeviceStatus(java.lang.String xml)*
     */
    public java.lang.String getDeviceStatus(java.lang.String xml) { 
        LOG.info("Executing operation getDeviceStatus");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAlarmChannel(java.lang.String xml)*
     */
    public java.lang.String getAlarmChannel(java.lang.String xml) { 
        LOG.info("Executing operation getAlarmChannel");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPassCarsCounting(java.lang.String xml)*
     */
    public java.lang.String getPassCarsCounting(java.lang.String xml) { 
        LOG.info("Executing operation getPassCarsCounting");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAlarmEventPage(java.lang.String xml)*
     */
    public java.lang.String getAlarmEventPage(java.lang.String xml) { 
        LOG.info("Executing operation getAlarmEventPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getIoPage(java.lang.String xml)*
     */
    public java.lang.String getIoPage(java.lang.String xml) { 
        LOG.info("Executing operation getIoPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPersonAndCards(java.lang.String xml)*
     */
    public java.lang.String getPersonAndCards(java.lang.String xml) { 
        LOG.info("Executing operation getPersonAndCards");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#importPersonAndCardInfo(java.lang.String xml)*
     */
    public java.lang.String importPersonAndCardInfo(java.lang.String xml) { 
        LOG.info("Executing operation importPersonAndCardInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getDepartments(java.lang.String xml)*
     */
    public java.lang.String getDepartments(java.lang.String xml) { 
        LOG.info("Executing operation getDepartments");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAccessDoorPage(java.lang.String xml)*
     */
    public java.lang.String getAccessDoorPage(java.lang.String xml) { 
        LOG.info("Executing operation getAccessDoorPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#deleteUser(java.lang.String xml)*
     */
    public java.lang.String deleteUser(java.lang.String xml) { 
        LOG.info("Executing operation deleteUser");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#userLogOut(java.lang.String xml)*
     */
    public java.lang.String userLogOut(java.lang.String xml) { 
        LOG.info("Executing operation userLogOut");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getControlUnitInfo(java.lang.String xml)*
     */
    public java.lang.String getControlUnitInfo(java.lang.String xml) { 
        LOG.info("Executing operation getControlUnitInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getCameraInfo(java.lang.String xml)*
     */
    public java.lang.String getCameraInfo(java.lang.String xml) { 
        LOG.info("Executing operation getCameraInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getRoutePage(java.lang.String xml)*
     */
    public java.lang.String getRoutePage(java.lang.String xml) { 
        LOG.info("Executing operation getRoutePage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAllPersonInspectionResult(java.lang.String xml)*
     */
    public java.lang.String getAllPersonInspectionResult(java.lang.String xml) { 
        LOG.info("Executing operation getAllPersonInspectionResult");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#userOnlineHearbeat(java.lang.String xml)*
     */
    public java.lang.String userOnlineHearbeat(java.lang.String xml) { 
        LOG.info("Executing operation userOnlineHearbeat");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getSchedulingHistoryPage(java.lang.String xml)*
     */
    public java.lang.String getSchedulingHistoryPage(java.lang.String xml) { 
        LOG.info("Executing operation getSchedulingHistoryPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPassCarsInfo(java.lang.String xml)*
     */
    public java.lang.String getPassCarsInfo(java.lang.String xml) { 
        LOG.info("Executing operation getPassCarsInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getPTZSeizeTime(java.lang.String xml)*
     */
    public java.lang.String getPTZSeizeTime(java.lang.String xml) { 
        LOG.info("Executing operation getPTZSeizeTime");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getParkingInfo(java.lang.String xml)*
     */
    public java.lang.String getParkingInfo(java.lang.String xml) { 
        LOG.info("Executing operation getParkingInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getEcsControlPage(java.lang.String xml)*
     */
    public java.lang.String getEcsControlPage(java.lang.String xml) { 
        LOG.info("Executing operation getEcsControlPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getParkingRegions(java.lang.String xml)*
     */
    public java.lang.String getParkingRegions(java.lang.String xml) { 
        LOG.info("Executing operation getParkingRegions");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#covertListToString(java.util.List<java.lang.String> list)*
     */
    public java.lang.String covertListToString(java.util.List<java.lang.String> list) { 
        LOG.info("Executing operation covertListToString");
        System.out.println(list);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAccessEventPage(java.lang.String xml)*
     */
    public java.lang.String getAccessEventPage(java.lang.String xml) { 
        LOG.info("Executing operation getAccessEventPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#doControl(java.lang.String xml)*
     */
    public java.lang.String doControl(java.lang.String xml) { 
        LOG.info("Executing operation doControl");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAllAlarmState(java.lang.String xml)*
     */
    public java.lang.String getAllAlarmState(java.lang.String xml) { 
        LOG.info("Executing operation getAllAlarmState");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getCameraPreviewUrl(java.lang.String xml)*
     */
    public java.lang.String getCameraPreviewUrl(java.lang.String xml) { 
        LOG.info("Executing operation getCameraPreviewUrl");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#addUser(java.lang.String xml)*
     */
    public java.lang.String addUser(java.lang.String xml) { 
        LOG.info("Executing operation addUser");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#deleteOpsThirdDeviceBySysCode(java.lang.String xml)*
     */
    public java.lang.String deleteOpsThirdDeviceBySysCode(java.lang.String xml) { 
        LOG.info("Executing operation deleteOpsThirdDeviceBySysCode");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getAlarmDeviceInfo(java.lang.String xml)*
     */
    public java.lang.String getAlarmDeviceInfo(java.lang.String xml) { 
        LOG.info("Executing operation getAlarmDeviceInfo");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hikvision.cms.ws.server.ThirdSdkServicePortType#getSchedulingPage(java.lang.String xml)*
     */
    public java.lang.String getSchedulingPage(java.lang.String xml) { 
        LOG.info("Executing operation getSchedulingPage");
        System.out.println(xml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
