package com.xls.fx.util.webservice.jaxrs;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.jaxrs
 * @ClassName: Car
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 21:43
 * @Version: v1.0
 **/
@JsonRootName("Car")
@Data
public class Car {
    private  int id ;
}
