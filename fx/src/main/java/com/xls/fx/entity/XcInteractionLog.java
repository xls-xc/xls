package com.xls.fx.entity;

import java.util.Date;

public class XcInteractionLog {
    /**
     * 星辰审批交互日志实体ID
     */
    private Integer xcInteractionLogId;

    /**
     * 对接系统名称
     */
    private String systemName;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 触发请求类名
     */
    private String className;

    /**
     * 触发请求方法名
     */
    private String methodName;

    /**
     * 请求时间
     */
    private Date requestTime;

    /**
     * 响应时间
     */
    private Date responseTime;

    /**
     * 请求时长
     */
    private Long responseTimeLong;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 响应参数
     */
    private String responseParam;

    /**
     * 返回值状态码
     */
    private Integer responseCode;

    /**
     * 操作人编号
     */
    private String userNo;

    /**
     * 操作人编码
     */
    private String userCode;

    /**
     * 操作人姓名
     */
    private String userName;

    /**
     * 备用字段
     */
    private String standbyField1;

    /**
     * 备用字段
     */
    private String standbyField2;

    /**
     * 备用字段
     */
    private String standbyField3;

    /**
     * 备用字段
     */
    private String standbyField4;

    /**
     * 备用字段
     */
    private String standbyField5;

    public Integer getXcInteractionLogId() {
        return xcInteractionLogId;
    }

    public void setXcInteractionLogId(Integer xcInteractionLogId) {
        this.xcInteractionLogId = xcInteractionLogId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
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
        this.requestParam = requestParam == null ? null : requestParam.trim();
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam == null ? null : responseParam.trim();
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
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getStandbyField1() {
        return standbyField1;
    }

    public void setStandbyField1(String standbyField1) {
        this.standbyField1 = standbyField1 == null ? null : standbyField1.trim();
    }

    public String getStandbyField2() {
        return standbyField2;
    }

    public void setStandbyField2(String standbyField2) {
        this.standbyField2 = standbyField2 == null ? null : standbyField2.trim();
    }

    public String getStandbyField3() {
        return standbyField3;
    }

    public void setStandbyField3(String standbyField3) {
        this.standbyField3 = standbyField3 == null ? null : standbyField3.trim();
    }

    public String getStandbyField4() {
        return standbyField4;
    }

    public void setStandbyField4(String standbyField4) {
        this.standbyField4 = standbyField4 == null ? null : standbyField4.trim();
    }

    public String getStandbyField5() {
        return standbyField5;
    }

    public void setStandbyField5(String standbyField5) {
        this.standbyField5 = standbyField5 == null ? null : standbyField5.trim();
    }
}