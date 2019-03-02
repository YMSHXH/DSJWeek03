package com.example.lib_network.network;

import com.blankj.utilcode.util.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 头部拦截器
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {


        Request originalRequest = chain.request();//原始请求对象
        Request nrequest = originalRequest.newBuilder()
//                .addHeader("userId",Shape_netdP.getmInstance().getSP("userId"))
//                .addHeader("sessionId",Shape_netdP.getmInstance().getSP("sessionId"))
                .addHeader("userId",SPUtils.getInstance().getString("userId"))
                .addHeader("sessionId",SPUtils.getInstance().getString("sessionId"))
                .build();

        Response response = chain.proceed(nrequest);

        return response;
    }
}