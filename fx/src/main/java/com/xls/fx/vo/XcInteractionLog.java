package com.xls.fx.vo;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenshuaikai
 * @since 2020-04-28
 */
@TableName("xc_interaction_log")
public class XcInteractionLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 星辰审批交互日志实体ID
     */
	@TableId(value="xc_interaction_log_id", type= IdType.AUTO)
	private Integer xcInteractionLogId;
    /**
     * 对接系统名称
     */
	@TableField("system_name")
	private String systemName;
    /**
     * 模块名称
     */
	@TableField("module_name")
	private String moduleName;
    /**
     * 菜单名称
     */
	@TableField("menu_name")
	private String menuName;
    /**
     * 请求地址
     */
	@TableField("request_url")
	private String requestUrl;
    /**
     * 触发请求类名
     */
	@TableField("class_name")
	private String className;
    /**
     * 触发请求方法名
     */
	@TableField("method_name")
	private String methodName;
    /**
     * 请求时间
     */
	@TableField("request_time")
	private Date requestTime;
    /**
     * 响应时间
     */
	@TableField("response_time")
	private Date responseTime;
    /**
     * 请求时长
     */
	@TableField("response_time_long")
	private Long responseTimeLong;
    /**
     * 请求参数
     */
	@TableField("request_param")
	private String requestParam;
    /**
     * 响应参数
     */
	@TableField("response_param")
	private String responseParam;
    /**
     * 返回值状态码
     */
	@TableField("response_code")
	private Integer responseCode;
    /**
     * 操作人编号
     */
	@TableField("user_no")
	private String userNo;
    /**
     * 操作人编码
     */
	@TableField("user_code")
	private String userCode;
    /**
     * 操作人姓名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 备用字段
     */
	@TableField("standby_field1")
	private String standbyField1;
    /**
     * 备用字段
     */
	@TableField("standby_field2")
	private String standbyField2;
    /**
     * 备用字段
     */
	@TableField("standby_field3")
	private String standbyField3;
    /**
     * 备用字段
     */
	@TableField("standby_field4")
	private String standbyField4;
    /**
     * 备用字段
     */
	@TableField("standby_field5")
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
