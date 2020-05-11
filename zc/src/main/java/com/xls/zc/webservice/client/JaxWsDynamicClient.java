package com.xls.zc.webservice.client;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.client
 * @ClassName: JaxWsDynamicClient
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-05-06 13:27
 * @Version: v1.0
 **/
public class JaxWsDynamicClient {
    public static void main(String[] args) throws Exception{
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:8080/webservice/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects=client.invoke("getUser","411001");
        //输出调用结果
        System.out.println("*****"+objects[0].toString());
    }
}
