package com.xls.fx.service.impl;

import com.alibaba.fastjson.JSON;
import com.xls.fx.config.SmsConfig;
import com.xls.fx.entity.SmsSendEntity;
import com.xls.fx.service.ISmsService;
import com.xls.fx.util.EncryptUtil;
import com.xls.fx.util.HttpClient4Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.service.impl
 * @ClassName: SmsServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 09:19
 * @Version: v1.0
 **/
@Service
public class SmsServiceImpl implements ISmsService {

    /***
     * 手机短信发送前缀
     */
    public static final String SMS_SEND_PREFIX = "86";

    /***
     * 短信发送配置类
     */
    @Autowired
    private SmsConfig smsConfig;


    @Override
    public String sendSMSCode(String phone, String content) {
        String smsId = UUID.randomUUID().toString();
        String nonce = ISmsService.generateRandomNumber(15);
        long timestamp = System.currentTimeMillis();
        SmsSendEntity sms = getNewSmsSendDto(content, phone, smsId, nonce, timestamp);
        //外网调用
        String result = HttpClient4Util.sendHttpPost(smsConfig.getUrl(), JSON.toJSONString(sms));
        return result;
    }

    @Override
    public SmsSendEntity getNewSmsSendDto(String content, String phone, String smsId, String nonce, long timestamp) {
        SmsSendEntity sms = new SmsSendEntity();
        sms.setAppCode(smsConfig.getAppCode());
        sms.setOrgCode(smsConfig.getOrgCode());
        sms.setAppSmsId(smsId);
        sms.setTemplateCode(smsConfig.getTemplateCode());
        sms.setMobile(SMS_SEND_PREFIX + phone);
        sms.setNonce(nonce);
        sms.setTimestamp(timestamp);
        List<String> params = new ArrayList<>(1);
        params.add(content);
        sms.setParams(params);
        String data = "timestamp=" + timestamp + "&nonce=" + nonce + "&signData=" + smsId;
        try {
            String sign = EncryptUtil.encryptSHA(data, smsConfig.getAppSecret());
            sms.setSign(sign);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sms;
    }
}
