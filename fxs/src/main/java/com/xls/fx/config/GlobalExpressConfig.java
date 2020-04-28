/*
package com.xls.fx.config;

import com.xls.fx.service.IExpressQueryService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

*
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.config
 * @ClassName: GlobalExpressConfig
 * @Description: 全局快递配置类
 * @Author: SkyChen
 * @Create: 2020-04-03 21:39
 * @Version: v1.0
 *

//@Configuration
public class GlobalExpressConfig {


*
     *
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/expressQueryService?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/cxf/expressQueryService?wsdl
     * @return


//    @SuppressWarnings("all")
//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
//    }



    private final Bus bus;


    private final IExpressQueryService iExpressQueryService;

*
     * 构造函数注入
     * @param iExpressQueryService


   //@Autowired
    public GlobalExpressConfig(Bus bus, @Qualifier("expressQueryServiceImpl") IExpressQueryService iExpressQueryService){
        this.bus = bus;
        this.iExpressQueryService = iExpressQueryService;
    }

*
     * Endpoint是用户订阅主题时，指定接收消息的终端地址；当有消息发布到主题时，MNS会主动将消息推送到对应的 Endpoint； 多个Subscription可以指定同一个Endpoint。
     *
     * HttpEndpoint
     * HTTP格式的Endpoint；
     * 格式：http://$company.com[/uri]，支持多级URI；
     * 限制：Endpoint的URI不能以”mns-reserverd-“开头；
     * MNS将发送HTTP请求到指定的Endpoint，用户在Endpoint端处理请求即可。
     *
     * QueueEndpoint
     * 以队列的资源描述作为Endpoint；
     * 格式：acs:mns:{REGION}:{AccountID}:queues/{QueueName} ；
     * 限制：只支持推送到主题同地域同账号的队列中；
     * MNS直接将消息写入到指定的队列中，用户通过receive message接口读取消息，具体使用方式请参见队列推送。
     *
     * MailEndpoint
     * 以Mail名称作为Endpoint；
     * 格式：mail:directmail:{MailAddress}；
     * MNS将以mail的形式将消息推送到指定的邮箱中，具体使用方式请参见邮件推送。
     * @return


    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,iExpressQueryService);
        endpoint.publish("/expressQueryService");
        System.out.println("expressQueryService发布···");

        return endpoint;

    }
}
*/
