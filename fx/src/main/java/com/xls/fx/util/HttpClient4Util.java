package com.xls.fx.util;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.MDC;




import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util
 * @ClassName: HttpClient
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-30 09:55
 * @Version: v1.0
 **/
public class HttpClient4Util {
    private static final String REQUEST_ID = "requestId";
    private static final String STR_ENCODE = "UTF-8";
    private static final String USER_AGENT = "user_agent";
    private static final String HJ_IBJ = "hj_ibj";

    private static RequestConfig REQUEST_CONFIG;

    private HttpClient4Util() { }

    /**
     * 发送 post请求
     * @param httpUrl 地址
     * @param header 请求头
     * @return string 字符串
     */
    public static String sendHttpPost(final String httpUrl, final Header... header) {
        // 创建httpPost
        HttpPost httpPost = new HttpPost(httpUrl);
        if (header != null) {
            httpPost.setHeaders(header);
        }
        return sendHttpPost(httpPost);
    }

    /**
     * 发送 post请求
     * @param httpUrl 地址
     * @param params 参数(格式:key1=value1&key2=value2)
     * @param header 请求头
     * @return string 字符串
     */
    public static String sendHttpPost(final String httpUrl, final String params, final Header... header) {
        // 创建httpPost
        HttpPost httpPost = new HttpPost(httpUrl);
        try {
            //设置参数
            StringEntity stringEntity = new StringEntity(params, STR_ENCODE);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            if (header != null) {
                httpPost.setHeaders(header);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }

    /**
     * post请求
     * @param httpUrl 地址
     * @param maps 参数
     * @param headers 请求头
     * @return string 响应字符串
     */
    public static String sendHttpPost(final String httpUrl, final Map<String, String> maps,
                                      final Map<String, String> headers) {
        // 创建httpPost
        HttpPost httpPost = new HttpPost(httpUrl);
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), maps.get(entry.getKey())));
        }
        try {
            if (null!=headers) {
                headers.forEach((n, k) -> {
                    httpPost.addHeader(new BasicHeader(n, k));
                });
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, STR_ENCODE));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }
    /**
     * 发送 post请求
     * @param httpUrl 地址
     * @param maps 参数
     * @param header 请求头
     * @return string 响应字符串
     */
    public static String sendHttpPost(final String httpUrl, final Map<String, String> maps, final Header... header) {
        // 创建httpPost
        HttpPost httpPost = new HttpPost(httpUrl);
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), maps.get(entry.getKey())));
        }
        try {
            if (header != null) {
                httpPost.setHeaders(header);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, STR_ENCODE));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }
    /**
     * 发送 post请求
     * @param httpUrl 地址
     * @param maps 参数
     * @return string 响应字符串
     */
    public static String sendHttpPost(final String httpUrl, final Map<String, String> maps) {
        // 创建httpPost
        HttpPost httpPost = new HttpPost(httpUrl);
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), maps.get(entry.getKey())));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, STR_ENCODE));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }

    /**
     * 发送 post请求
     * @param httpUrl 地址
     * @param maps 参数
     * @param headers 请求头
     * @return string 响应字符串
     */
    public static String sendHttpPut(final String httpUrl, final Map<String, String> maps, final Header... headers) {
        // 创建httpPost
        HttpPut httpPut = new HttpPut(httpUrl);
        if (headers != null) {
            httpPut.setHeaders(headers);
        }
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), maps.get(entry.getKey())));
        }
        try {
            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs, STR_ENCODE));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sendHttpRequest(httpPut);
    }

    /**
     * 发送 put请求
     * @param httpUrl 地址
     * @param params 参数(格式:key1=value1&key2=value2)
     * @param header 请求头
     * @return string 响应字符串
     */
    public static String sendHttpPut(final String httpUrl, final String params, final Header... header) {
        HttpPut httpPut = new HttpPut(httpUrl);
        try {
            // 设置参数
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType("application/json");
            httpPut.setEntity(stringEntity);
            if (header != null) {
                httpPut.setHeaders(header);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sendHttpRequest(httpPut);
    }

    /**
     * 发送Post请求
     * @param httpPost the httpPost
     * @return string 响应字符串
     */
    private static String sendHttpPost(final HttpPost httpPost) {
        return HttpClient4Util.sendHttpRequest(httpPost);
    }
    /**
     * 发送 get请求
     * @param httpUrl 地址
     * @return string 响应字符串
     */
    public static String sendHttpGet(final String httpUrl) {
        // 创建get请求
        HttpGet httpGet = new HttpGet(httpUrl);
        return sendHttpGet(httpGet);
    }

    /**
     * 发送 get请求
     * @param httpUrl 地址
     * @param header 请求头
     * @return string 响应字符串
     */
    public static String sendHttpGet(final String httpUrl, final Header... header) {
        // 创建get请求
        HttpGet httpGet = new HttpGet(httpUrl);
        if (header != null) {
            httpGet.setHeaders(header);
        }
        return sendHttpGet(httpGet);
    }

    /**
     * 发送 get请求Https
     * @param httpUrl 地址
     * @param header 请求头
     * @return string 响应字符串
     * @throws Exception 异常
     */
    public static String sendHttpsGet(final String httpUrl, final Header... header) throws Exception {
        // 创建get请求
        HttpGet httpGet = new HttpGet(httpUrl);
        if (header != null) {
            httpGet.setHeaders(header);
        }
        return sendHttpsGet(httpGet);
    }

    /**
     * 发送Get请求
     * @param httpGet
     * @return string 响应字符串
     */
    private static String sendHttpGet(final HttpGet httpGet) {
        return sendHttpRequest(httpGet);
    }

    /**
     * 发送Get请求Https
     * @param httpGet the httpGet
     * @return string 响应字符串
     */
    private static String sendHttpsGet(final HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(new URL(httpGet.getURI().toString()));
            DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
            httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
            httpGet.setConfig(REQUEST_CONFIG);
            //在http header中存入requestId
            setRequestId(httpGet);
            // 执行请求
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, STR_ENCODE);
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                HttpClient4Util.closeResources(response, httpClient);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 发送Get请求Https
     * @param httpRequestBase the httpRequestBase
     * @return string 响应字符串
     */
    public static String sendHttpRequest(final HttpRequestBase httpRequestBase) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        long start = System.currentTimeMillis();
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpRequestBase.setConfig(REQUEST_CONFIG);
            //在http header中存入requestId
            setRequestId(httpRequestBase);
            // 执行请求
            response = httpClient.execute(httpRequestBase);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, STR_ENCODE);
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                HttpClient4Util.closeResources(response, httpClient);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    private static void closeResources(final CloseableHttpResponse closeableHttpResponse, final CloseableHttpClient closeableHttpClient) throws IOException {
        if (closeableHttpResponse != null) {
            closeableHttpResponse.close();
        }
        if (closeableHttpClient != null) {
            closeableHttpClient.close();
        }
    }

    private static void setRequestId(final HttpMessage httpMessage) {
        httpMessage.addHeader(REQUEST_ID, MDC.get(REQUEST_ID));
        httpMessage.addHeader(USER_AGENT, HJ_IBJ);
    }
}
