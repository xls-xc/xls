package com.xls.zc.http;

import com.xls.zc.http.base.SslUtilsBase;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.zc.http
 * @ClassName: HttpRequest
 * @Description: java原生HttpURLConnection  发送http请求
 * 目前JAVA实现HTTP请求的方法用的最多的有两种：
 * 一种是通过HTTPClient这种第三方的开源框架去实现。HTTPClient对HTTP的封装性比较不错，通过它基本上能够满足我们大部分的需求，
 * HttpClient3.1 是 org.apache.commons.httpclient下操作远程 url的工具包，虽然已不再更新，但实现工作中使用httpClient3.1的代码还是很多，
 * 二是HttpClient4.5是org.apache.http.client下操作远程 url的工具包，最新的；
 * 另一种则是通过HttpURLConnection去实现，HttpURLConnection是JAVA的标准类，是JAVA比较原生的一种实现方式。
 * @Author: SkyChen
 * @Create: 2020-04-24 19:53
 * @Version: v1.0
 **/
public class HttpRequest {

    public static void main(String[] args) throws Exception {
        String path6 = "http://219.128.90.188:5902/touce/rest/landInfo/getCityData";
        Map<String, String> header = new HashMap<String, String>();
        header.put("accept", "*/*");
        header.put("connection", "Keep-Alive");
        header.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        System.out.println(sendGet(path6, "", header));
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static String sendGet(String url, String param, Map<String, String> header) throws Exception {
        String result = "";
        BufferedReader in = null;
        Integer index = param.indexOf("=");
        param = param.substring(0, index + 1) + URLEncoder.encode(param.substring(index + 1, param.length()), "utf-8");
        String urlNameString = url + "?" + param;
        System.out.println("urlNameString" + urlNameString);
        URL realUrl = new URL(urlNameString);
        SslUtilsBase.ignoreSsl();
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        //设置超时时间
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(1000000);
        // 设置通用的请求属性
        if (header != null) {
            Iterator<Map.Entry<String, String>> it = header.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                System.out.println(entry.getKey() + ":::" + entry.getValue());
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connection.setRequestProperty("charset", "utf-8");
        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
        Map<String, List<String>> map = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
        // 定义 BufferedReader输入流来读取URL的响应，设置utf8防止中文乱码
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if (in != null) {
            in.close();
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static StringBuffer getHttpData(String path) {
        try {
            //创建url对象
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //请求方式
            conn.setRequestMethod("POST");
            //创建一个打印流
            PrintWriter out = null;
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			/*设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，
			     此外发送post请求必须设置这两个最常用的Http请求无非是get和post，get请求可以获取静态页面，
			     也可以把参数放在URL字串后面，传递给servlet，post与get的 不同之处在于post的参数不是放在URL字串里面，
			     而是放在http请求的正文内
			*/
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
//            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(sb);
            //关闭流
            is.close();
		   /*断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。
			 如果正在被其他线程使用就不切断。固定多线程的话，如果不disconnect，链接会增多，
			 直到收发不出信息。写上disconnect后正常一些。
		   */
            conn.disconnect();
            return sb;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
