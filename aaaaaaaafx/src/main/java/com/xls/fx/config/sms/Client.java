package com.xls.fx.config.sms;

import com.xls.fx.config.emay.Mo;
import com.xls.fx.config.emay.SDKServiceLocator;
import com.xls.fx.config.emay.SdkServiceBindingStub;
import com.xls.fx.config.emay.StatusReport;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.config.sms
 * @ClassName: Clinet
 * @Description: 连接对象
 * @Author: SkyChen
 * @Create: 2020-04-13 17:07
 * @Version: v1.0
 **/
public class Client {

    SdkServiceBindingStub binding;

    /**
     * 软件序列码
     */
    private String softwareSerialNo;
    /**
     * key值
     */
    private String key;

    public Client(String softwareSerialNo, String key){
        this.softwareSerialNo = softwareSerialNo;
        this.key=key;
        init();
    }

    public void init(){
        try {
            binding = (SdkServiceBindingStub) new SDKServiceLocator().getSDKService();
        } catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null) {
                jre.getLinkedCause().printStackTrace();
            }
        }
    }




    public int sendSMS( String[] mobiles, String smsContent, String addSerial,int smsPriority) throws RemoteException {
        int value=-1;
        value=binding.sendSMS(softwareSerialNo, key,"", mobiles, smsContent, addSerial, "gbk", smsPriority,0);
        return value;
    }

    public int sendScheduledSMSEx(String[] mobiles, String smsContent,String sendTime,String srcCharset)
            throws RemoteException {
        int value=-1;
        value=binding.sendSMS(softwareSerialNo, key, sendTime, mobiles, smsContent, "", srcCharset, 3,0);
        return value;
    }
    public int sendSMSEx(String[] mobiles, String smsContent, String addSerial,String srcCharset, int smsPriority,long smsID)
            throws RemoteException {
        int value=-1;
        value=binding.sendSMS(softwareSerialNo, key,"", mobiles, smsContent,addSerial, srcCharset, smsPriority,smsID);
        return value;
    }

}

