package com.xls.zc.webservice.axis2;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.axis2
 * @ClassName: Test
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-22 15:27
 * @Version: v1.0
 **/
@Component(value = "test")
public class Test {
    public String greek(String greekWord){
        System.out.print("hello World!");
        return greekWord;
    }
}

