package com.teambition.tool.util;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by yingchun on 2017/10/27.
 */
public class OkHttp3Utils {
    private static OkHttpClient okHttpClient = null;

    private OkHttp3Utils() {

    }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OkHttp3Utils.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient().newBuilder()
                            .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                            .readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
                            .writeTimeout(10, TimeUnit.SECONDS)//设置写入超时时间
                            .build();
                }
            }
        }

        return okHttpClient;
    }

    public static String doGet(String url) throws IOException {
        return doGet(url, new HashMap<>());
    }

    public static String doGet(String url, Map<String, String> headers) throws IOException {
        //获取请求对象的实例
        OkHttpClient okHttpClient = OkHttp3Utils.getInstance();
        Request.Builder builder = new Request.Builder().url(url);
        if (null != headers) {
            builder.headers(Headers.of(headers));
        }
        Request request = builder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public static void doGet(String url, Callback callback) {
        doGet(url, null, callback);
    }

    public static void doGet(String url, Map<String, String> headers, Callback callback) {
        //获取请求对象的实例
        OkHttpClient okHttpClient = OkHttp3Utils.getInstance();
        //创建Request
        Request.Builder builder = new Request.Builder().url(url);
        if (null != headers) {
            builder.headers(Headers.of(headers));
        }

        Request request = builder.build();
        //得到Call
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }

    public static String doPost(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
        //获取请求对象的实例
        OkHttpClient okHttpClient = OkHttp3Utils.getInstance();
        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        //遍历map集合给请求体添加值
        if (null != params) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }

        Request.Builder requestBuilder = new Request.Builder().url(url).post(builder.build());
        if (null != headers) {
            requestBuilder.headers(Headers.of(headers));
        }

        //创建Request
        Request request = requestBuilder.build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }


    public static void doPost(String url, Map<String, String> params, Map<String, String> headers, Callback callback) {
        //获取请求对象的实例
        OkHttpClient okHttpClient = OkHttp3Utils.getInstance();
        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        //遍历map集合给请求体添加值
        if (null != params) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).post(builder.build());
        if (null != headers) {
            requestBuilder.headers(Headers.of(headers));
        }
        //创建Request
        Request request = requestBuilder.build();
        //获取call
        Call call = okHttpClient.newCall(request);
        //异步请求
        call.enqueue(callback);
    }

    public static String doPostJson(String url, String jsonParams, Map<String, String> headers) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request.Builder builder = new Request.Builder().url(url).post(requestBody);
        if (null != headers) {
            builder.headers(Headers.of(headers));
        }
        Request request = builder.build();
        Response response = getInstance().newCall(request).execute();
        return response.body().string();
    }


    public static void doPostJson(String url, String jsonParams, Map<String, String> headers, Callback callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request.Builder builder = new Request.Builder().url(url).post(requestBody);
        if (null != headers) {
            builder.headers(Headers.of(headers));
        }
        Request request = builder.build();
        Call callbacll = getInstance().newCall(request);
        callbacll.enqueue(callback);
    }

    public static void main(String[] args) throws IOException {
        OkHttp3Utils.doGet("http://192.168.0.22:8319/event/model/pageList", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("failed");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("success" + response.body().string());
            }
        });
    }

}
