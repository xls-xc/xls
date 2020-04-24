package com.xls.fx.util.webservice.axis2;


import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.webservice.cxf
 * @ClassName: User
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-15 13:13
 * @Version: v1.0
 **/
@Data
public class User {
    private static final long serialVersionUID = -5939599230753662523L;
    private String  userId;
    private String  username;
    private String  age;
    private Date updateTime;
}
