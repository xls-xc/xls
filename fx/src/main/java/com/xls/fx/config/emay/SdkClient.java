package com.xls.fx.config.emay;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.fx.config.emay
 * @InterfaceName: SdkClient
 * @Description: 还没有添加接口的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-13 17:37
 * @Version: v1.0
 **/
public interface SdkClient extends java.rmi.Remote{
    /**
     * 发送消息
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @return
     * @throws java.rmi.RemoteException
     */
    int sendSMS(String arg0, String arg1, String arg2, String[] arg3, String arg4, String arg5, String arg6, int arg7, long arg8) throws java.rmi.RemoteException;
}
