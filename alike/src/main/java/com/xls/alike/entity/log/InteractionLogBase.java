package com.xls.alike.entity.log;

import java.util.Date;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.entity.log
 * @ClassName: InteractinLogBase
 * @Description: 交互日志基础类实体
 * @Author: SkyChen
 * @Create: 2020-04-25 10:36
 * @Version: v1.0
 **/
public class InteractionLogBase {

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
     * 响应时长
     */
    private Integer timeLong;

    /**
     * 请求参数 text
     */
    private String requestParam;

    /**
     * 响应参数
     */
    private String responseParam;

    /**
     * 返回值状态吗
     */
    private String code;


    /**
     * 操作人编号
     */
    private String  userNo;

    /**
     * 操作人编码
     */
    private String  userCode;

    /**
     * 操作人姓名
     */
    private String userName;



    /**
     * 备用字段
     */

    private String standbyField1;

    private String standbyField2;

    private String standbyField3;

    private String standbyField4;

    private String standbyField5;

    /*private String paramRequestTime;//请求时间

    private String paramResponseTime;//响应时间

    private Integer current_page;//当前页

    private Integer size;//页面大小

    private Integer start_page;//开始查询页*/

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

    public Integer getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(Integer timeLong) {
        this.timeLong = timeLong;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
