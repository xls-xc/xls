package com.xls.fx.service.impl;

import com.xls.fx.config.sms.SingletonClient;
import com.xls.fx.entity.SendMessage;
import com.xls.fx.service.ISmsSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.service.impl
 * @ClassName: SmsSendServiceImpl
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-13 15:58
 * @Version: v1.0
 **/
@Service
public class SmsSendServiceImpl implements ISmsSendService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String send(String smsMessage, boolean isNow) {
        return null;
    }

    @Override
    public void sendSms(SendMessage sendMessage) {
        try {

            String[] number = new String[]{"8617703751364"};
            String content = "测试短信息";
            // 带扩展码
            int i = SingletonClient.getClient().sendSMS(number, content, "", 5);
            logger.info("发送接口返回值为：" + i);
            logger.info("发送了消息到：" + sendMessage.getNumber());
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
