package com.xls.fx.config.emay;

public class SdkClientProxy implements SdkClient{
  private String _endpoint = null;
  private SdkClient sDKClient = null;
  
  public SdkClientProxy() {
    _initSDKClientProxy();
  }
  
  public SdkClientProxy(String endpoint) {
    _endpoint = endpoint;
    _initSDKClientProxy();
  }
  
  private void _initSDKClientProxy() {
    try {
      sDKClient = (new SDKServiceLocator()).getSDKService();
      if (sDKClient != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sDKClient)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sDKClient)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sDKClient != null)
      ((javax.xml.rpc.Stub)sDKClient)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public SdkClient getSDKClient() {
    if (sDKClient == null)
      _initSDKClientProxy();
    return sDKClient;
  }



  @Override
  public int sendSMS(String arg0, String arg1, String arg2, String[] arg3, String arg4, String arg5, String arg6, int arg7, long arg8) throws java.rmi.RemoteException{
    if (sDKClient == null){

      _initSDKClientProxy();
    }
    return sDKClient.sendSMS(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  
  
}