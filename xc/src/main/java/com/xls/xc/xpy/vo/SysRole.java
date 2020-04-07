package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: SysRole
 * @Description: 角色的实体类
 * @Author: SkyChen
 * @Create: 2020-04-07 21:52
 * @Version: v1.0
 **/
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseObject<SysRole> implements Serializable {

    /**
     * 角色ID
     */
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int userId;


    /**
     * 角色上级ID
     */
    @Column(name = "role_parent_id")
    private String roleParentId;

    /**
     * 角色优先级
     */
    @Column(name = "role_level")
    private String roleLevel;

    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private int roleCode;
    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色职能
     */
    @Column(name = "role_function")
    private String roleFunction;

    /**
     * 角色描述
     */
    @Column(name = "role_description")
    private String roleDescription;

    /**
     * 角色状态：0未启用，1启用(默认启用)
     */
    @Column(name = "role_status")
    private int roleStats;








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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleParentId() {
        return roleParentId;
    }

    public void setRoleParentId(String roleParentId) {
        this.roleParentId = roleParentId;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleFunction() {
        return roleFunction;
    }

    public void setRoleFunction(String roleFunction) {
        this.roleFunction = roleFunction;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public int getRoleStats() {
        return roleStats;
    }

    public void setRoleStats(int roleStats) {
        this.roleStats = roleStats;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getStandbyField1() {
        return standbyField1;
    }

    public void setStandbyField1(String standbyField1) {
        this.standbyField1 = standbyField1;
    }

    public Integer getStandbyField2() {
        return standbyField2;
    }

    public void setStandbyField2(Integer standbyField2) {
        this.standbyField2 = standbyField2;
    }

    public String getStandbyField3() {
        return standbyField3;
    }

    public void setStandbyField3(String standbyField3) {
        this.standbyField3 = standbyField3;
    }

    public String getStandbyField4() {
        return standbyField4;
    }

    public void setStandbyField4(String standbyField4) {
        this.standbyField4 = standbyField4;
    }

    public String getStandbyField5() {
        return standbyField5;
    }

    public void setStandbyField5(String standbyField5) {
        this.standbyField5 = standbyField5;
    }
}
