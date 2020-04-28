package com.xls.fx.service;

import com.caucho.hessian.client.HessianProxyFactory;
import com.xls.fx.config.EncryptUtil;
import com.xls.fx.entity.Message;
import com.xls.fx.util.request.HttpRequest;
import com.xls.fx.service.impl.SmsSendServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ISmsSendServiceTest {

    //业务系统编码
    static String appCode ="USER_APP_000023";

    //业务系统模板编码
    static String templateCode ="USER_TEMPLATE_000145";

    //业务系统的组织编码(例如总部999999)
    static String orgCode ="999999";

    //短信平台随机生成的业务系统key(主要用于外网对接时生成签名)
     static String appSecret = "0fc124";

//   注意外网调试和内网两种接入的区别，到时候我们上线使用的是内网


     static String url1 = "http://jingangtest.yto56.com.cn/smssendsoa/remote/smssend";//金刚测试环境地址
     static String url2 = "http://jingang.yto56.com.cn/smssendsoa/remote/smssend";//金刚生产环境地址
     static String url3 = "http://10.128.4.31:8080/sms-platform-api/send";//发送香港短信地址
     static String url4 = "http://10.1.227.58:8081/smssendsoa/remote/smssend";//金刚测试环境地址

    //外网调试地址
     static String url5 = "http://message.yto56.com.cn:9092/sms/oneSend";
     //内网调试地址（上线用内网调试地址）
     static String url6 = "http://10.128.4.98:9093/sms/oneSend";

     @Test
     public void httpRequest() {
         String s = HttpRequest.sendPost(url5, getSendParam(null));
         System.out.println(s);
     }

    @Test
    public void send() {
        String dafasf = sendSms("dafasf", "8617703751364");
        System.out.println(dafasf);
    }

    @Test
    public void sendSms(){
        ISmsSendService iSmsSendService = new SmsSendServiceImpl();
        iSmsSendService.sendSms(null);
    }


    public static String sendSms(String content,String phone){


        HessianProxyFactory factory = new HessianProxyFactory();


        ISmsSendService iSmsSendService = null;
        try {
            iSmsSendService = (ISmsSendService) factory.create(ISmsSendService.class, url5);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        List<String> a = new ArrayList<>();

        Message message = new Message();
        message.setAppCode(appCode);
        message.setAppSmsId(UUID.randomUUID().toString());
        message.setMobile("8617703751364");
        message.setNonce("11111");
        message.setOrgCode(orgCode);
        message.setParams(a);
        message.setTemplateCode(templateCode);
        message.setTimestamp(System.currentTimeMillis());

        String data = "timestamp="+message.getTimestamp()+"&nonce="+message.getNonce()+"&signData="+message.getAppSmsId();
        String sign = EncryptUtil.encryptSHA(data,appSecret);

        message.setSign(sign);

        String jsonString = JSONObject.toJSONString(message);
        String ret=iSmsSendService.send(jsonString,true);
        System.out.println("ret"+ret);
        return jsonString;
    }

    public String getSendParam(Object object) {
        List<String> a = new ArrayList<>();

        Message message = new Message();
        message.setAppCode(appCode);
        message.setAppSmsId(UUID.randomUUID().toString());
        message.setMobile("8617703751364");
        message.setNonce("11111");
        message.setOrgCode(orgCode);
        message.setUserCode("00001");
        message.setParams(a);
        message.setTemplateCode(templateCode);
        message.setTimestamp(System.currentTimeMillis());

        String data = "timestamp="+message.getTimestamp()+"&nonce="+message.getNonce()+"&signData="+message.getAppSmsId();
        String sign = EncryptUtil.encryptSHA(data,appSecret);

        message.setSign(sign);

        return JSONObject.toJSONString(message);
    }
}