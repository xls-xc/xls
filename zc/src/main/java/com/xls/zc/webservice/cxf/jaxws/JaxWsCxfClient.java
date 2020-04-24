package com.xls.zc.webservice.cxf.jaxws;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxws
 * @ClassName: JaxWsCxfClient
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-17 17:17
 * @Version: v1.0
 **/
public class JaxWsCxfClient {
    private static final String CALL_ADDR="http://localhost:8080/cxf/jaxws/iUserService?wsdl";

    public static void main(String[] args) {
        //创建CXF代理工厂  可以对接口生成代理对象，代理对象子再访问远程服务端接口
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        //设置远程访问地址
        factory.setAddress(CALL_ADDR);

        //设置接口类型
        factory.setServiceClass(IUserClientService.class);

        //对接口生成代理对象

        IUserClientService iUserClientService = factory.create(IUserClientService.class);

        //代理对象类型 class com.sun.proxy.$Proxy34 [Java代理：1.静态代理；2.动态代理（jdk接口代理 如：$Proxy34，cglib代理如：$CGLIB34）]
        System.out.println("代理对象类型：" + iUserClientService.getClass());

        //远程访问服务端方法
        String content = iUserClientService.getName("1");

        //调用远程接口返回的内容
        System.out.println("调用远程接口返回的内容:" + content);
    }
}
