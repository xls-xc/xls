package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: SysUserRole
 * @Description: 用户角色实体类
 * @Author: SkyChen
 * @Create: 2020-04-07 21:54
 * @Version: v1.0
 **/
public class SysUserRole extends BaseObject<SysUserRole> implements Serializable {
    /**
     * 用户角色ID
     */
    @Id
    @GeneratedValue
    @Column(name = "user_role_id")
    private int roleMenuId;


    /**
     * 用户编号
     */
    @Column(name = "user_no")
    private String roleNo;

    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String menuNo;

    /**
     * 用户角色描述
     */
    @Column(name = "user_role_description")
    private String userRoleDescription;


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


    /**
     * 备用字段1
     */
    @Column(name = "standby_field_1")
    private String standbyField1;

    /**
     * 备用字段2
     */
    @Transient
    @Column(name = "standby_field_2")
    private Integer standbyField2;

    /**
     * 备用字段3
     */
    @Transient
    @Column(name = "standby_field_3")
    private String standbyField3;

    /**
     * 备用字段4
     */
    @Transient
    @Column(name = "standby_field_4")
    private String standbyField4;

    /**
     * 备用字段5
     */
    @Transient
    @Column(name = "standby_field_5")
    private String standbyField5;
}
