package com.xls.fx.util.webservice.axis2;


import org.apache.axis.transport.http.AxisServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.cxf
 * @ClassName: server
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 13:24
 * @Version: v1.0
 **/
//@Configuration
public class Axis2ServerConfig {

    @Bean
    public ServletRegistrationBean createServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

        //这里的AxisServlet就是web.xml中的org.apache.axis2.transport.http.AxisServlet
        servletRegistrationBean.setServlet(new AxisServlet());
        servletRegistrationBean.addUrlMappings("/services/*");
        //通过默认路径无法找到services.xml，这里需要指定一下路径，且必须是绝对路径
        String path = this.getClass().getResource("/WEB-INF").getPath().toString();
        System.out.println("The original path：" + path);
        if(path.toLowerCase().startsWith("file:")){
           System.out.println("去掉前面的“file:”！");
            path = path.substring(5);
        }
        if(path.indexOf("!") != -1){
            try {
               System.out.println("将WEB-INF/services/MyWebService/META-INF/services.xml文件拷贝到jar包同级目录下！");
                FileCopyUtils.copy("WEB-INF/services/MyWebService/META-INF/services.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
           System.out.println("jar包运行！查找jar包同级目录下的“/WEB-INF”目录");
            path = path.substring(0, path.lastIndexOf("/", path.indexOf("!"))) + "/WEB-INF";
        }
       System.out.println("The final path：" + path);
        servletRegistrationBean.addInitParameter("axis2.repository.path", path);
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

}
