package com.xls.zc.webservice.jws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.service.impl
 * @ClassName: ExpressQueryServiceByJavaApiIml
 * @Description: 基于java自带API实现默认的Webservice发布  默认只会发布接口的方法，实现类自定义的方法不会被发布了
 * @Author: SkyChen
 * @Create: 2020-04-05 13:36
 * @Version: v1.0
 **/
@WebService
public class DefaultServiceImpl {


    /**
     * 默认方法名getInfo
     * 默认参数名arg0
     * 默认返回值名字：return
     * targetNamespace默认情况下为倒置的包名
     * @param queryParam
     * @return
     */
    public String getInfo(String queryParam) {
        System.out.println("请求信息:" + queryParam);
        return "返回的响应信息!";
    }

    /**
     * 静态和非public方法不会被自动发布
     * @param param
     * @return
     */
    public static String staticTestMethod(String param){
        return "静态方法"+param;
    }

    public static void main(String[] args) {
        //implementor要发布的对象，一般是接口的实现类
        String address="http://127.0.0.1/DefaultServiceImpl?WSDL";
        Endpoint point = Endpoint.publish(address, new DefaultServiceImpl());
        System.out.println("WebService发布成功，地址为：" + address);
        //关闭发布
        //point.stop();


    }
}
