package com.xls.zc.webservice.cxf.jaxrs;

import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxrs
 * @ClassName: ICarService
 * @Description: @Produces 支持的返回数据的格式类型
 *  *            @Consumes 服务器支持的请求的数据格式类型
 *               **代表支持所有的类型
 * @Author: SkyChen
 * @Create: 2020-04-16 21:36
 * @Version: v1.0
 **/
@Path("/iCarService")
@Produces("*/*")
public interface ICarService {
    @POST
    @Path("/car")
    @Consumes({"application/xml","application/json","text/plain"})
    void save(String car);

    @PUT
    @Path("/car")
    @Consumes({"application/xml","application/json","text/plain"})
    void update(String car);

    @GET
    @Path("/car")
    @Produces({"application/xml","application/json","text/plain"})
    String findAll();

    @GET
    @Path("/car/{id}")
    @Consumes({"application/xml","application/json","text/plain"})
    @Produces({"application/xml","application/json","text/plain"})
    String findById(@PathParam("id")Integer carId);

    @DELETE
    @Path("/car/{id}")
    @Consumes({"application/xml","application/json","text/plain"})
    void delById(@PathParam("id") Integer carId);
}
