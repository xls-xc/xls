package com.xls.fx.util.webservice.java;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.java
 * @ClassName: ServiceByCustom
 * @Description: 基于Java自带API实现自定义的Webservice发布  默认只会发布接口的方法，实现类自定义的方法不会被发布了
 * @Author: SkyChen
 * @Create: 2020-04-05 13:57
 * @Version: v1.0
 **/
@WebService(serviceName="ServiceByCustom",targetNamespace="http://java.webService.fx.xls.com")
public class ServiceByCustom {
    /**
     * @param queryParam
     * @return
     */
    @WebMethod(operationName="getInfo")
    @WebResult(name = "returnInfo")
    public String getInfo(@WebParam(name="queryParam")String queryParam) {
        System.out.println("请求信息:" + queryParam);
        return "返回的响应信息!";
    }

    /**
     * 静态，非public方法不会被自动发布
     * @param param
     * @return
     */
    public static String staticTestMethod(String param){
        return "静态方法"+param;
    }

    /**
     * 屏蔽要发布的方法
     * @param queryParam1
     * @return
     */
    @WebMethod(exclude=true)
    public  String excludeTest1(String queryParam1){
        return "queryParam1:"+queryParam1;
    }

    public  String excludeTest2(String queryParam2){
        return "queryParam2:"+queryParam2;
    }


    //访问时自动生成一个描述文件xml+xsd约束文件
    public static void main(String[] args) {
        //implementor要发布的对象，一般是接口的实现类
        String address="http://127.0.0.1/ServiceByCustom?WSDL";
        Endpoint point = Endpoint.publish(address, new ServiceByCustom());
        //关闭发布
        //point.stop();


    }
}
