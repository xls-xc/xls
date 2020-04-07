package com.xls.xc.xpy.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xls.xc.xpy.common.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: SysMenu
 * @Description: 菜单的实体类
 * @Author: SkyChen
 * @Create: 2020-04-07 21:53
 * @Version: v1.0
 **/
@Entity
@Table(name = "sys_menu")
public class SysMenu extends BaseObject<SysMenu> implements Serializable {


    /**
     * 菜单ID
     */
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private int menuId;

    /**
     * 菜单父级ID
     */
    @Column(name = "menu_parent_id")
    private int menuParentId;

    /**
     * 菜单组ID
     */
    @Column(name = "menu_group_id")
    private int menuGroupId;

    /**
     * 菜单级别
     */
    @Column(name = "menu_level")
    private int menuLevel;


    /**
     * 菜单优先级
     */
    @Column(name = "menu_priority")
    private int menuPriority;

    /**
     * 菜单编号
     */
    @Column(name = "menu_no")
    private String menuNo;

    /**
     * 菜单编码
     */
    @Column(name = "menu_code")
    private int menuCode;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private int menuName;


    /**
     * 菜单描述
     */
    @Column(name = "menu_description")
    private String menuDescription;

    /**
     * 菜单图标
     */
    @Column(name = "menu_icon")
    private int menuIcon;

    /**
     * 菜单路径：一级菜单url为空
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 菜单状态：0未启用，1启用(默认启用)
     */
    @Column(name = "menu_status")
    private int menuStatus;



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

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(int menuParentId) {
        this.menuParentId = menuParentId;
    }

    public int getMenuGroupId() {
        return menuGroupId;
    }

    public void setMenuGroupId(int menuGroupId) {
        this.menuGroupId = menuGroupId;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public int getMenuPriority() {
        return menuPriority;
    }

    public void setMenuPriority(int menuPriority) {
        this.menuPriority = menuPriority;
    }

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getMenuName() {
        return menuName;
    }

    public void setMenuName(int menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(int menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
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
