/**
 * SDKService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xls.fx.config.emay;

public interface SDKService extends javax.xml.rpc.Service {
    public String getSDKServiceAddress();

    public SdkClient getSDKService() throws javax.xml.rpc.ServiceException;

    public SdkClient getSDKService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
