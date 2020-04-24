package com.xls.zc.webservice.cxf.jaxrs;

import com.xls.zc.webservice.entity.User;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.webservice.cxf.jaxrs
 * @ClassName: Car
 * @Description: 基于restful风格的webservice，客户端与服务端之间通讯可以传递xml数据、json数据
 *   --@XmlRootElement： 指定对象序列化为xml或json数据时根节点名称
 * @Author: SkyChen
 * @Create: 2020-04-16 21:29
 * @Version: v1.0
 **/
@XmlRootElement(name = "Car")
@Data
public class Car {
    private Integer carId;
    private String carName;
    private List<User> users = new ArrayList<>();
}
