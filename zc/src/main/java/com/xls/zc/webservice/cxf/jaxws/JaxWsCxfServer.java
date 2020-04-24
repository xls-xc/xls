package com.xls.zc.webservice.cxf.jaxws;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxws
 * @ClassName: JaxWsCxfServer
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-17 15:17
 * @Version: v1.0
 **/
public class JaxWsCxfServer {
    private static final String SERVICE_ADDR="http://localhost:8080/cxf/jaxws/iUserService?wsdl";

    public static void main(String[] args) {

        //创建发布服务的工厂
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();

        //设置服务地址
        factory.setAddress(SERVICE_ADDR);

        //设置服务类
        factory.setServiceBean(new UserServiceImpl());

        //发布服务
        factory.create();

        System.out.println("JAX-WS WebService服务发布成功,地址："+SERVICE_ADDR);

    }
}
