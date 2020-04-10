package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: SysUserPassword
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-10 21:06
 * @Version: v1.0
 **/
@Entity
@Table(name = "sys_user_password")
public class SysUserPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "password_id")
    private int passwordId;
    /**
     * 创建人
     */
    @Column(name = "user_no")
    private String userNo;
    /**
     * 创建人
     */
    @Column(name = "password_no")
    private String passwordNo;
    /**
     * 创建人
     */
    @Column(name = "password_value")
    private String passwordValue;
    /**
     * 创建人
     */
    @Column(name = "password_salt")
    private String passwordSalt;

    /**
     * 密码状态：0未启用，1启用(默认启用)
     */
    @Column(name = "password_status")
    private int passwordStats;


    /**
     * 创建人
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 修改人
     */
    @Column(name = "update_user_name")
    private String updateUserName;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 删除标识：0未删除，1已删除
     */
    @Column(name = "is_del")
    private int isDel;


    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Column(name = "create_time")
    private Timestamp createTime;
}
