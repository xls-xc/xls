package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: SysDept
 * @Description: 部门实体类
 * @Author: SkyChen
 * @Create: 2020-04-07 21:52
 * @Version: v1.0
 **/
@Entity
@Table(name = "sys_dept",schema = "xc")
public class SysDept extends BaseObject<SysDept> implements Serializable {




    /**
     * 部门ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int userId;


    /**
     * 部门上级ID
     */
    @Column(name = "dept_parent_id")
    private int roleParentId;

    /**
     * 部门优先级
     */
    @Column(name = "dept_level")
    private int deptLevel;

    /**
     * 部门编号
     */
    @Column(name = "dept_no")
    private String deptNo;

    /**
     * 部门编码
     */
    @Column(name = "dept_code")
    private String deptCode;
    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 部门职能
     */
    @Column(name = "dept_function")
    private String deptFunction;

    /**
     * 部门描述
     */
    @Column(name = "dept_description")
    private String deptDescription;

    /**
     * 部门状态：0未启用，1启用(默认启用)
     */
    @Column(name = "dept_status")
    private int deptStats;








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

    @Column(name = "standby_field_2")
    private String standbyField2;

    /**
     * 备用字段3
     */

    @Column(name = "standby_field_3")
    private String standbyField3;

    /**
     * 备用字段4
     */

    @Column(name = "standby_field_4")
    private String standbyField4;

    /**
     * 备用字段5
     */

    @Column(name = "standby_field_5")
    private String standbyField5;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleParentId() {
        return roleParentId;
    }

    public void setRoleParentId(int roleParentId) {
        this.roleParentId = roleParentId;
    }

    public int getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(int deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptFunction() {
        return deptFunction;
    }

    public void setDeptFunction(String deptFunction) {
        this.deptFunction = deptFunction;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public int getDeptStats() {
        return deptStats;
    }

    public void setDeptStats(int deptStats) {
        this.deptStats = deptStats;
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

    public String getStandbyField2() {
        return standbyField2;
    }

    public void setStandbyField2(String standbyField2) {
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
