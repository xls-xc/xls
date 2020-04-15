package com.xls.fx.util.request;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util.request
 * @ClassName: OKHttp
 * @Description: 还没有添加类的描述信息
 * okhttp : 用于文件下载和上传
 * okio: 用于文件的传输(和okhttp绑定)
 * @Author: SkyChen
 * @Create: 2020-04-14 20:28
 * @Version: v1.0
 **/
public class OKHttp3 {

    public static void main(String[] args) {
    }


    /**
     * 文件直接下载
     */
    public static void oMaDownload() {
        //创建连接客户端
        OkHttpClient client = new OkHttpClient();
        //设置提交参数(post)
        FormBody form = new FormBody.Builder()
                .add("rows", "5")//添加参数的键值对
                .build();
        Request request = new Request.Builder()
                .url("http://www.tngou.net/api/cook/list")
                .post(form)//给post设置参数;
                .build();
        //创建"调用" 对象
        Call call = client.newCall(request);
        try {
            Response response = call.execute();//执行
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 异步下载 其实更多的人使用这种方式
     */
    public static void asynchronousDownload() {
        //创建连接客户端
        OkHttpClient client = new OkHttpClient();
        //设置提交参数(post)
        FormBody form = new FormBody.Builder()
                .add("rows", "5")//添加参数的键值对
                .build();
        Request request = new Request.Builder()
                .url("http://www.tngou.net/api/cook/list")
                .post(form)//给post设置参数;
                .build();
        //创建"调用" 对象
        Call call = client.newCall(request);
        //调用Callback(接口) 如果失败回调onFailure方法,如果有响应调用onResponse方法
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //访问失败, 打印访问地址
                Request r = call.request();
                System.out.println("请求失败: " + r.url());
                System.out.println(r.body());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("请求有响应" + call.request().url());
                System.out.println("响应码: " + response.code());
                System.out.println("请求内容: " + response.body().string());
            }
        });
    }


    /**
     * 文件上传
     */
    public static void fileUploadDemo() {
        //还是先创建客户端
        OkHttpClient client = new OkHttpClient();
        //待上传文件
        File file = new File("C:\\abc.txt");

        MultipartBody.Part part = MultipartBody.Part
                .createFormData("upload", file.getName(),
                        RequestBody.create(MultipartBody.FORM, file));
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", "lulu")//这个参数在服务器端可以接收到
                .addFormDataPart("upload", file.getName(), RequestBody.create(MultipartBody.FORM, file))
                .build();

        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080/test")
                .post(multipartBody)
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.out.println("访问失败:" + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
