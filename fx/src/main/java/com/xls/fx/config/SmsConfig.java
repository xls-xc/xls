package com.xls.fx.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.config
 * @ClassName: SmsConfig
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 09:13
 * @Version: v1.0
 **/
@Configuration
@Data
public class SmsConfig {
    @Value("${sms.url}")
    private String url;

    @Value("${sms.orgCode}")
    private String orgCode;

    @Value("${sms.appSecret}")
    private String appSecret;

    @Value("${sms.appCode}")
    private String appCode;

    @Value("${sms.templateCode}")
    private String templateCode;
}
