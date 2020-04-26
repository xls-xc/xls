package com.xls.xc.xpy.vo;


import com.xls.alike.util.TimeUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.xc.xpy.vo
 * @ClassName: XcApproveInteractionLogVo
 * @Description: 星辰审批交互日志实体
 * @Author: SkyChen
 * @Create: 2020-04-26 20:37
 * @Version: v1.0
 **/
@Entity
@Table(name = "xc_interaction_log")
public class XcInteractionLogVo {



    /**
     * 求响应时长
     * @param xcInteractionLogVo
     * @return
     */
    @Transient
    public Long getResponseTimeLong(XcInteractionLogVo xcInteractionLogVo) {
        Date requestTime = xcInteractionLogVo.getRequestTime();
        Date responseTime = xcInteractionLogVo.getResponseTime();
        return TimeUtil.getTimeDifference(requestTime,responseTime);
    }



    /**
     * 星辰审批交互日志实体ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xc_interaction_log_id")
    private int xcInteractionLogId;

    /**
     * 对接系统名称
     */
    @Column(name = "system_name")
    private String systemName;


    /**
     * 模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 请求地址
     */
    @Column(name = "request_url")
    private String requestUrl;

    /**
     * 触发请求类名
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 触发请求方法名
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 请求时间
     */
    @Column(name = "request_time")
    private Date requestTime;

    /**
     * 响应时间
     */
    @Column(name = "response_time")
    private Date responseTime;

    /**
     * 响应时长
     */
    @Column(name = "response_time_long")
    private Long responseTimeLong;

    /**
     * 请求参数 text
     */
    @Column(name = "request_param")
    private String requestParam;

    /**
     * 响应参数
     */
    @Column(name = "response_param")
    private String responseParam;

    /**
     * 返回值状态码
     */
    @Column(name = "response_code")
    private Integer responseCode;


    /**
     * 操作人编号
     */
    @Column(name = "user_no")
    private String  userNo;

    /**
     * 操作人编码
     */
    @Column(name = "user_code")
    private String  userCode;

    /**
     * 操作人姓名
     */
    @Column(name = "user_name")
    private String userName;



    /**
     * 备用字段
     */
    @Column(name = "standby_field1")
    private String standbyField1;
    @Column(name = "standby_field2")
    private String standbyField2;
    @Column(name = "standby_field3")
    private String standbyField3;
    @Column(name = "standby_field4")
    private String standbyField4;
    @Column(name = "standby_field5")
    private String standbyField5;


    public int getXcInteractionLogId() {
        return xcInteractionLogId;
    }

    public void setXcInteractionLogId(int xcInteractionLogId) {
        this.xcInteractionLogId = xcInteractionLogId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Long getResponseTimeLong() {
        return responseTimeLong;
    }

    public void setResponseTimeLong(Long responseTimeLong) {
        this.responseTimeLong = responseTimeLong;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
