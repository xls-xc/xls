package com.xls.fx.webservice.jaxrs;

import javax.ws.rs.*;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.webservice.jaxrs
 * @ClassName: PublishTest
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-05 14:46
 * @Version: v1.0
 **/
@Path("/iPublishService")
@Produces("*/*")
public interface iPublishService {
    @POST
    @Path("/test")
    void saveParam(String saveParam);

    @PUT
    @Path("/test")
    @Consumes({"application/xml","application/json"})
    void updateParam(String updateParam);

    @GET
    @Path("/test")
    // @Produces({"text/plain;"}) 设置为该文本格式后 可以在浏览器直接打印  ，不然浏览器显示不出来
    @Produces({"application/xml","application/json"})
    List<String> findAllParams();

    @GET
    @Path("/test/{id}")
    @Consumes("application/xml")
    @Produces({"application/xml","application/json"})
    String findParamById(@PathParam("id")Integer id);

    @DELETE
    @Path("/test/{id}")
    @Consumes({"application/xml","application/json"})
    void delParamById(@PathParam("id") Integer id);
}
