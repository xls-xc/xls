package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: SysRoleMenu
 * @Description: 角色菜单中间表实体类
 * @Author: SkyChen
 * @Create: 2020-04-07 21:54
 * @Version: v1.0
 **/
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu extends BaseObject<SysRoleMenu> implements Serializable {
    /**
     * 角色菜单中间表ID
     */
    @Id
    @GeneratedValue
    @Column(name = "role_menu_id")
    private int roleMenuId;


    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 菜单编号
     */
    @Column(name = "menu_no")
    private String menuNo;

    /**
     * 角色菜单描述
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

    public int getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(int roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    public String getUserRoleDescription() {
        return userRoleDescription;
    }

    public void setUserRoleDescription(String userRoleDescription) {
        this.userRoleDescription = userRoleDescription;
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
