package com.xls.zc.webservice.cxf.jaxrs;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxrs
 * @ClassName: JaxRsCxfPublish
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 22:02
 * @Version: v1.0
 **/
public class JaxRsCxfServer {
    private static final String SERVER_ADDR="http://localhost:8080/cxf/jaxrs";

    public static void main(String[] args) {
        //创建发布服务的工厂
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();

        //设置服务地址
        factory.setAddress(SERVER_ADDR);

        //设置服务类
        factory.setServiceBean(new CarServiceImpl());

        //添加日志输入输入出拦截器
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());

        //发布服务
        factory.create();

        System.out.println("发布服务成功，根地址是：" + SERVER_ADDR);
    }
}
