package com.xls.fx.service.impl;


import com.xls.fx.service.ISmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmsServiceImplTest {

    private String phone = "17703751364";
    private String content = "测试内容";

    @Autowired
    ISmsService iSmsService;

    @Test
    public void sendSMSCode() {
        System.out.println(iSmsService.sendSMSCode(phone, content));
    }

    @Test
    public void getNewSmsSendDto() {
    }
}