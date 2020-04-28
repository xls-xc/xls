package com.xls.fx.util.webservice.jaxws;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

//基于HttpPost发送请求
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.namespace.QName;

//基于axis发送请求
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;


import org.dom4j.Element;
//基于测试 导入的包
//import org.junit.platform.commons.util.StringUtils;




/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.test
 * @ClassName: ManMethodExpressQueryTest
 * @Description: 主函数测试查询快递信息
 * @Author: SkyChen
 * @Create: 2020-04-04 20:40
 * @Version: v1.0
 **/
public class ManMethodExpressQueryTest {
    private static String webServiceUrl= "http://127.0.0.1:8080/services/expressQueryService?wsdl";
    private static String namespaceURI = "http://service.fx.xls.com";
    private static String methodName = "selectExpressInfo";
    private static String paramName = "selectInfo";
    private static String returnParamName = "expressInfo";
    private static String paramValue = "我进行了测试请求";
    private static Boolean isGet = true;
    private static String Optional = "<!--Optional:-->";

    public static void main(String[] args) {
       test1(isGet);
       //test2();
       //test3();
    }


    /**
     * 使用HttpClient的方式发送请求
     * HttpClient：可以用来调用webService服务，也可以抓取网页数据
     *
     * @param sign
     */
    public static void test1(Boolean sign) {
        String result="";
        try {
            if(sign) {

               /*
                org.apache.commons.httpclient.HttpClient client1 = new org.apache.commons.httpclient.HttpClient();
               1.调用Get方法示例
                org.apache.commons.httpclient.methods.GetMethod getMethod = new org.apache.commons.httpclient.methods.GetMethod("http://localhost:8080/test/method?paramname=paramvalue");
                响应状态吗
                 int code = client1.executeMethod(getMethod);
                 结果
                  result = getMethod.getResponseBodyAsString();

                 2.调用post方法示例
                org.apache.commons.httpclient.methods.PostMethod postMethod = new org.apache.commons.httpclient.methods.PostMethod("http://localhost:8080/test/method");
                设置参数
                postMethod.setParameter("parameterName", "parameterValue");
                响应状态吗
                int code = client1.executeMethod(postMethod);
                结果
                result = postMethod.getResponseBodyAsString();
                */



                StringBuilder xml = new StringBuilder("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\""+namespaceURI+"\">\n");
                xml.append("   <soapenv:Header/>\n");
                xml.append("       <soapenv:Body>\n");
                xml.append("         <ser:"+methodName+">\n");
                xml.append("         "+Optional+"\n");
                xml.append("            <"+paramName+">"+paramValue+"</"+paramName+">\n");
                xml.append("         </ser:"+methodName+">\n");
                xml.append("          </soapenv:Body>\n");
                xml.append("</soapenv:Envelope>");



               //原始的调用方式
                org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();
                org.apache.commons.httpclient.methods.PostMethod  postMethod = new org.apache.commons.httpclient.methods.PostMethod(webServiceUrl);
                byte[] bytes = xml.toString().getBytes("UTF-8");
                InputStream byteArrayInputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
                org.apache.commons.httpclient.methods.RequestEntity inputStreamRequestEntity = new org.apache.commons.httpclient.methods.InputStreamRequestEntity(byteArrayInputStream, bytes.length, "application/soap+xml; charset=utf-8");
                postMethod.setRequestEntity(inputStreamRequestEntity);
                int statusCode = client.executeMethod(postMethod);
                System.out.println("消息码："+statusCode);
                if (statusCode== HttpURLConnection.HTTP_OK) {
                    //得到执行结果
                    result = postMethod.getResponseBodyAsString();
                    System.out.println(result);
                }

                //新的调用方式
                HttpClient httpClient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(webServiceUrl);
                httpPost.setHeader("content-type", "application/soap+xml; charset=UTF-8");
                StringEntity stringEntity = new StringEntity(xml.toString());
                httpPost.setEntity(stringEntity);
                HttpResponse execute = httpClient.execute(httpPost);
                String contentXml = EntityUtils.toString(execute.getEntity());
                System.out.println(contentXml);

                org.dom4j.Document document = org.dom4j.DocumentHelper.parseText(contentXml);
                //获取根节点
                Element rootNode = document.getRootElement();
                String nodeValue = getNodeValue(rootNode, returnParamName);
                System.out.println("返回的内容："+nodeValue);


            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 基于JaxWs调用  使用的依赖
     *
     *         <dependency>
     *             <groupId>org.apache.cxf</groupId>
     *             <artifactId>cxf-rt-frontend-jaxws</artifactId>
     *             <version>3.1.10</version>
     *         </dependency>
     *         <dependency>
     *             <groupId>org.apache.cxf</groupId>
     *             <artifactId>cxf-rt-transports-http</artifactId>
     *             <version>3.1.10</version>
     *         </dependency>
     *
     * 在这里使用springboot+JaxWs
     * 依赖在pom文件中有
     */
    public static void test2() {
        try{
            org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory clientFactroy = org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory.newInstance();
            org.apache.cxf.endpoint.Client client = clientFactroy.createClient(webServiceUrl);
            //如果有命名空间的话  第一个参数为命名空间名称，第二个参数为WebService方法名称
            QName operationName = new QName(namespaceURI,methodName);
            //方法名，参数组，可以是多个参数 如果部署的方法
            Object[] invoke = client.invoke(operationName, paramValue);

            //如果没有ing名空间可以这样
            //Object[] invoke2 = client.invoke(methodName, requestParam);
            System.out.println(invoke[0].toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 基于axis发送请求
     */
    public static void test3() {

        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            // 设置访问地址
            call.setTargetEndpointAddress(new URL(webServiceUrl));

             // 是否使用SOAPAction
                call.setUseSOAPAction(false);
            // 设置SOAPAction地址
            //  call.setSOAPActionURI(soapAction);

            // 设置访问方法名称
            call.setOperationName(new QName(namespaceURI, methodName));
            // 添加参数名称
            call.addParameter(paramName, XMLType.XSD_STRING, ParameterMode.IN);
            // 添加解析类型的地址
           // call.setEncodingStyle(namespaceURI);
            // 设置返回值类型
            call.setReturnType(XMLType.XSD_STRING);

            //请求参数
            Object[] obj = new Object[1];
            obj[0] = paramValue;

            Object invoke = call.invoke(obj);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 递归判断节点是否是自己想要的key
     * @param node 节点名称
     * @param key  想要的key
     * @return
     *
     *
     *  isNotEmpty(str)等价于 str != null && str.length > 0
     *  isNotBlank(str) 等价于 str != null && str.length > 0 && str.trim().length > 0
     *  同理
     *  isEmpty 等价于 str == null || str.length == 0
     *  isBlank  等价于 str == null || str.length == 0 || str.trim().length == 0
     */
    public static String getNodeValue(final Element node,final String key) {
        String text = null;
        String textTrim = null;

        String rootNodeName = node.getName();

        //去空格节点的文本
        textTrim = node.getTextTrim();

        //原始节点文本
        text = node.getText();
        //判断根节点是否是想要的key的值，如果不是则是有子节点

        if (key.equals(rootNodeName)) {
            return text;
        }
        //获取所有节点
        final List<org.dom4j.Element> listElement = node.elements();
        //遍历子节点
        for (final org.dom4j.Element e : listElement) {
            // 递归
            text = getNodeValue(e, key);
           /* if (StringUtils.isNotBlank(textTrim)) {
                return textTrim;
            }*/
        }
        return text;
    }
}
