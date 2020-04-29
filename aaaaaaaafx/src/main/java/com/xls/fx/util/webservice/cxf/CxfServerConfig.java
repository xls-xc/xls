package com.xls.fx.util.webservice.cxf;


import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.cxf
 * @ClassName: server
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 13:24
 * @Version: v1.0
 **/
@Configuration
public class CxfServerConfig {

    /**
     *
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/userService?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/cxf/userService?wsdl
     * @return
     */
//    @SuppressWarnings("all")
//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
//    }

 /*   private final Bus bus;
    private final IUserService iUserService;


    *//**
     * 构造函数注入
     * @param iUserService
     *//*
    @Autowired
    public ServerConfig(Bus bus, @Qualifier("userServiceImpl")IUserService iUserService){
        this.bus = bus;
        this.iUserService = iUserService;
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,iUserService);
        endpoint.publish("/userService");
        System.out.println("CXF》》》  http://127.0.0.1:8080/services/userService?wsdl  发布···");
        return endpoint;
    }*/



    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus  SpringBus() {
        return new SpringBus();
    }

    @Bean
    public IUserService userService()
    {
        return  new UserServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(SpringBus(),userService());
        endpoint.publish("/userService");
        System.out.println("CXF》》》  http://127.0.0.1:8080/services/userService?wsdl  发布···");
        return endpoint;
    }
}
