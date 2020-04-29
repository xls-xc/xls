package com.xls.xc.xpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.controller
 * @ClassName: SelfTest
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-28 22:38
 * @Version: v1.0
 **/
@Controller
public class SelfTest extends Thread{
    @RequestMapping("/test")
    public void test(Integer a) {
        aaa(a);
    }

    @Override
    public void run() {
        Integer a = null;
        for (int i=0;i<100000000;i++) {
            a=0;
            System.out.println(a);
        }
    }

    public  void aaa(Integer a ) {
        for (int i=0;i<a;i++) {
            SelfTest bbb = new SelfTest();
            bbb.start();
        }
    }

}
