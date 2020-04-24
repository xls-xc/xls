package com.xls.fx.util.webservice.jaxrs;

import javax.ws.rs.*;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jaxrs
 * @ClassName: PublishTest
 * @Description: 基于JaxRs 发布restful风格的webservice接口
 * @Author: SkyChen
 * @Create: 2020-04-05 14:46
 * @Version: v1.0
 **/
@Path("/iJaxRsService")
@Produces("*/*")
public interface IJaxRsService {
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
    List<User> findAllParams();

    @GET
    @Path("/test/{id}")
    @Produces({"application/xml","application/json"})
    User findParamById(@PathParam("id")Integer id);

    @DELETE
    @Path("/test/{id}")
    @Consumes({"application/xml","application/json"})
    void delParamById(@PathParam("id") Integer id);
}
