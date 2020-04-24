/*
package com.xls.zc.http.base;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


*/
/**
 * 客户端webService工具
 * 
 * @author zhangtiecheng
 *
 *//*

@SuppressWarnings("H3Client")
@Component
public class H3ClientUtils {

	*/
/**
	 * 错误输入日志
	 *//*

	public static final Logger log = LoggerFactory.getLogger(H3ClientUtils.class);


	public final String utf = "UTF-8";

	private ClientModel getResponse(final String xmlJson, final String url) throws Exception {

		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		StringEntity postingString = new StringEntity(xmlJson, this.utf);// json传�??
		postingString.setContentEncoding(this.utf);
		post.setEntity(postingString);
 		post.setHeader("Content-Type", "application/soap+xml; charset=UTF-8");
		HttpResponse response = httpClient.execute(post);
		String content = EntityUtils.toString(response.getEntity());
		String retJson = XMLUtils.getRoot(content, "return");
		System.out.println("retJson=="+retJson);
		ClientModel clientModel= JSONObject.parseObject(retJson, ClientModel.class);
		if(clientModel==null){
			clientModel=new ClientModel();
			clientModel.setErrmsg("接口返回为空");
		}else{
			clientModel.setReqData(retJson);
			clientModel.setResponseData(retJson);
		}
		return  clientModel;
	}

	private String getResponseForCancle(final String xmlJson, final String url) throws Exception {

		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		StringEntity postingString = new StringEntity(xmlJson, this.utf);// json传�??
		postingString.setContentEncoding(this.utf);
		post.setEntity(postingString);
		post.setHeader("Content-Type", "application/soap+xml; charset=UTF-8");
		HttpResponse response = httpClient.execute(post);
		String content = EntityUtils.toString(response.getEntity());
		return XMLUtils.getRoot(content, "CancelInstanceResult");
	}

	*/
/**
	 * 调用H3提供的对外方�?
	 * 
	 * @param workflowCode
	 *            流程模板编码
	 * @param userCode
	 *            BIP用户账号
	 * @param flag
	 *            是否直接提交填写申请步骤
	 * @param json
	 *            流程实例启动初始化数据项集合（JSON格式）；包含（多）子表�?�审批人及附�?
	 * @return
	 *//*


	public final String Optional = "<!--Optional:-->";

	public ClientModel ModelXML(
			final String arg1,final String arg2,final String json,  final String url) {

		String json1 = json.replace("&", "&amp;");
		String soapRequestData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:imp=\"http://webservice.Itf.bs.nc/ImportNCData\">";
		soapRequestData += "<soapenv:Header/>";
		soapRequestData += "<soapenv:Body>";
		soapRequestData += "<imp:importNCData>";
		soapRequestData += this.Optional;
		soapRequestData += "<string>";
		soapRequestData += arg1;
		soapRequestData += "</string>";
		soapRequestData += this.Optional;
		soapRequestData += "<string1>";
		soapRequestData += arg2;
		soapRequestData += "</string1>";
		soapRequestData += this.Optional;
		soapRequestData += "<string2>";
		soapRequestData += json1;
		soapRequestData += "</string2>";
		soapRequestData += "</imp:importNCData>";
		soapRequestData += "</soapenv:Body>";
		soapRequestData += "</soapenv:Envelope>";
		ClientModel cm;

		try {
			System.out.println(soapRequestData);
			
			cm = getResponse(soapRequestData, url);
			return cm;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e+"");
			cm=new ClientModel();
			cm.setReqData(soapRequestData);
			return cm;
		}
	}

	public static void main(String[] args) {
		H3ClientUtils h3ClientUtils=new H3ClientUtils();
//		String json="";
//		Map<String,Object> map=new HashMap();
//		map.put("suppliername","桐庐远鹏印务有限公司1");
//		map.put("suppliercode","20001");
//		map.put("pk_supplierclass","0101");
//		json=JsonHelper.toJson(map);
//		System.out.println(json);
//		ClientModel clientModel=h3ClientUtils.ModelXML("01","02",json,"http://116.228.115.243:9081/uapws/service/nc.bs.Itf.webservice.ImportNCData");
//		System.out.printf("clientModel==="+clientModel.getFlag());
//
//		Map<String,Object> ncOrderMap=new HashMap<>();
//		ncOrderMap.put("pk_org","YT");//采购组织-- 传输编码
//		ncOrderMap.put("pk_reqstoorg","圆通速递有限公司");//需求库存组织 传名称
//
//		ncOrderMap.put("ctrantypeid","21-01");//订单类型
//
//		ncOrderMap.put("pk_supplier","s000392");//供应商
//
////		ncOrderMap.put("cemployeeid","00092720");//cemployeeidNC参数设置默认值 具体默认值待确定  目前定的 00092720=刘丽霞
//////
////		ncOrderMap.put("pk_dept","SD00700000");//采购部门NC参数设置默认值 具体默认值待确定 目前定的SD00700000=采购管理中心X
//
//		ncOrderMap.put("pk_cgtype","01");//采购方式 01
//
//		ncOrderMap.put("vdef6","20190523000005");//SRM采购订单号
//		List<Map<String,Object>> itemList=new ArrayList<>();
//			Map<String,Object> ncOrderItemMap=new HashMap<>();
//			ncOrderItemMap.put("pk_material","0105090021");//物料编码
//			ncOrderItemMap.put("nnum","30");//数量
//			ncOrderItemMap.put("nqtorigtaxprice","20");//含税单价
//			ncOrderItemMap.put("norigtaxmny","600");//含税金额
//			ncOrderItemMap.put("ntaxrate","16");//税率 数值 格式 16.00、7.00
//			ncOrderItemMap.put("ctaxcountryid","CN");//报税国家 默认CN
//			ncOrderItemMap.put("ctaxcodeid","CN05");//税码
//			ncOrderItemMap.put("vbdef4","上海 上海市 青浦区华徐公路3029弄18号");//收货地址
//			ncOrderItemMap.put("vbdef7","10");//SRM行号
//			itemList.add(ncOrderItemMap);
//		ncOrderMap.put("items",itemList);
//		Map<String,Object> dataMap=new HashMap<>();
//		dataMap.put("data",ncOrderMap);
//		ClientModel clientModel=h3ClientUtils.ModelXML("02","02",JsonHelper.toJson(dataMap),"http://116.228.115.243:9081/uapws/service/nc.bs.Itf.webservice.ImportNCData");
	//0105030234
		String price="65.3";
		String price1="0";
		boolean flag=new BigDecimal(price).compareTo(new BigDecimal(price1))<=0;
		if(new BigDecimal(price).compareTo(new BigDecimal(price1))>=0){
			System.out.println(111+"");

		}
		System.out.println(flag+"");

	}

}
*/
