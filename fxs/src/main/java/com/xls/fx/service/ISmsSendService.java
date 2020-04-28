package com.xls.fx.service;

import com.xls.fx.entity.SendMessage;

/**
 * @ProjectName: xls(星辰)
 * @PackageName: com.xls.fx.service
 * @InterfaceName: ISmsSendService
 * @Description: 短信发送接口
 * @Author: SkyChen
 * @Create: 2020-04-13 15:38
 * @Version: v1.0
 **/
public interface ISmsSendService {


    /**
     * 信息发送的方法
     * @param smsMessage 消息实体类
     * @param isNow 是否现在发送
     * @return String "短信送到手机" "success" "error"
     */
    String send(String smsMessage, boolean isNow);

    /**
     * 发送短信
     * @param sendMessage
     */
    void sendSms(SendMessage sendMessage);
}
