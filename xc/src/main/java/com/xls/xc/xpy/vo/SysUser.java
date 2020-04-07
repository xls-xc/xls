package com.xls.xc.xpy.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: User
 * @Description: 用户实体类
 * @Author: SkyChen
 * @Create: 2020-04-07 19:54
 * @Version: v1.0
 **/
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseObject<SysUser> implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    /**
     * 用户编号(唯一)
     */
    @Column(name = "user_no")
    private String userNo;


    /**
     * 用户编码(唯一)
     */
    @Column(name = "user_code")
    private String userCode;


    /**
     * 用户账号(唯一)
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 用户名字
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户手机号：如果多个可以用:分隔符号分开储存（分隔符号第一个为主要的）
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户地址
     */
    @Column(name = "user_address")
    private String userAddress;


    /**
     * 部门编号，多个部门用:分隔符号隔开
     */
    @Column(name = "dept_no")
    private String deptNo;

    /**
     * 部门名称，多个部门用:分隔符号隔开
     */
    @Column(name = "dept_name")
    private String deptName;


    /**
     * 角色编号，多个角色用:分割符号隔开
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 角色名称,  多个角色用:分割符号隔开
     */
    @Column(name = "role_name")
    private String roleName;



    /**
     * 职位编号，多个职位用:分割符号隔开
     */
    @Column(name = "job_no")
    private String jobNo;

    /**
     * 职位名称，多个职位用:分割符号隔开
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 用户状态：0未启用，1启用
     */
    @Column(name = "status")
    private String status;

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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
