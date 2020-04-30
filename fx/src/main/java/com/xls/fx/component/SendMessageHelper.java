package com.xls.fx.component;

import com.alibaba.fastjson.JSON;
import com.xls.fx.constant.MessageTemplateSendType;
import com.xls.fx.constant.RedisQueueName;
import com.xls.fx.entity.SendMessageEntity;
import com.xls.fx.service.ISmsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util
 * @ClassName: SendMessageHelper
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 10:20
 * @Version: v1.0
 **/
@Component
public class SendMessageHelper {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ISmsService iSmsService;

    @Autowired
    private RedisQueueHelper redisQueueHelper;
    /**
     * 加入队列
     * @param number
     * @param content
     */
    public void pushQueueSms(String number, String content) {
        logger.info("加入队列:SendMessageHelper->pushQueueSms->number值为"+number);
        logger.info("加入队列:SendMessageHelper->pushQueueSms->content值为"+content);
        if (StringUtils.isBlank(number)) {
            logger.error("加入SMS队列失败，number为空");
            return;
        }
        if (StringUtils.isBlank(content)) {
            logger.error("加入SMS队列失败，content为空");
            return;
        }
        SendMessageEntity sendMessageEntity = new SendMessageEntity();
        sendMessageEntity.setNumber(number);
        sendMessageEntity.setContent(content);
        sendMessageEntity.setSendType(MessageTemplateSendType.SMS);
       // String jsonString = JsonHelper.toJson(sendMessageEntity);
        String jsonString = JSON.toJSONString(sendMessageEntity);
        //短信
        String result = iSmsService.sendSMSCode(number,content);
        logger.error("短信返回結果，result");
        redisQueueHelper.push(RedisQueueName.MESSAGE, jsonString);
    }

    /**
     * 加入队列
     * @param number
     * @param title
     * @param content
     */
    public void pushQueueEmail(String number, String title, String content) {
        if (StringUtils.isBlank(number)) {
            logger.error("加入EMAIL队列失败，number为空");
            return;
        }
        if (StringUtils.isBlank(title)) {
            logger.error("加入EMAIL队列失败，title为空");
            return;
        }
        if (StringUtils.isBlank(content)) {
            logger.error("加入EMAIL队列失败，content为空");
            return;
        }
        SendMessageEntity sendMessageEntity = new SendMessageEntity();
        sendMessageEntity.setNumber(number);
        sendMessageEntity.setTitle(title);
        sendMessageEntity.setContent(content);
        sendMessageEntity.setSendType(MessageTemplateSendType.EMAIL);
        String jsonString =  JSON.toJSONString(sendMessageEntity);
        redisQueueHelper.push(RedisQueueName.MESSAGE, jsonString);
    }

    /**
     * 微信模板消息加入队列
     * @param memberId
     * @param templateId
     * @param toUrl
     * @param weixinDataParams
     */
    public void pushQueueWeixin(int memberId, String templateId, String toUrl, HashMap<String,Object> weixinDataParams) {
        HashMap<String,Object> contentMap = new HashMap<>();
        contentMap.put("templateId", templateId);
        contentMap.put("toUrl", toUrl);
        contentMap.put("dataParams", weixinDataParams);

        SendMessageEntity sendMessageEntity = new SendMessageEntity();
        sendMessageEntity.setNumber(String.valueOf(memberId));
        sendMessageEntity.setTitle("");
        sendMessageEntity.setContent(JSON.toJSONString(contentMap));
        sendMessageEntity.setSendType(MessageTemplateSendType.WEIXIN);
        logger.info("微信模板消息加入队列:SendMessageHelper->pushQueueWeixin->sendMessage值为" + sendMessageEntity);
        String jsonString = JSON.toJSONString(sendMessageEntity);
        logger.info("微信模板消息加入队列:SendMessageHelper->pushQueueWeixin->jsonString值为"+jsonString);
        redisQueueHelper.push(RedisQueueName.MESSAGE, jsonString);
    }

    /**
     * 发送消息
     * @param sendMessageEntity
     */
    public void send(SendMessageEntity sendMessageEntity) {
        System.out.println(sendMessageEntity);
    }

    /**
     * 模板字符串替换
     * @param string
     * @param map
     * @return
     *
     *
     *       String string = "<p>您好！</p>\n" +
     *       "<p>您刚才在{$site_name}重置了密码，新密码为：{$new_password}。</p>\n" +
     *       "<p>请尽快登录 <a href=\"{$site_url}\" target=\"_blank\">{$site_url}</a> 修改密码。</p>";
     *       HashMap<String, Object> map = new HashMap<>();
     *       map.put("site_name", "B2B2C JAVA版");
     *       map.put("new_password", "1101101111110");
     *       map.put("site_url", "");
     *       String stringNew = sendMessageHelper.replace(string, map);
     *       System.out.println(stringNew);
     */
    public String replace(String string, HashMap<String, Object> map) {
        if (string == null || string.length() == 0) {
            return "";
        }
        for (String key : map.keySet()) {
            string = string.replace("{$" + key + "}", String.valueOf(map.get(key)));
        }
        return string;
    }
}
