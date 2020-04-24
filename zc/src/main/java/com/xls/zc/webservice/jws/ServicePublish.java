package com.xls.zc.webservice.jws;

import javax.xml.ws.Endpoint;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jws
 * @ClassName: ServicePublish
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-16 20:10
 * @Version: v1.0
 **/
public class ServicePublish {

    public static void main(String[] args) {
        //implementor要发布的对象，一般是接口的实现类
        String address="http://127.0.0.1/iUserService?WSDL";
        Endpoint point = Endpoint.publish(address, new UserServiceImpl());
        System.out.println("WebService发布成功，地址为：" + address);
        //关闭发布
        //point.stop();


    }
}
