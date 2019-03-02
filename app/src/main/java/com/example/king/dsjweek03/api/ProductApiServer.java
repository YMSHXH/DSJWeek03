package com.example.king.dsjweek03.api;

import com.example.king.dsjweek03.bean.DanBean;
import com.example.king.dsjweek03.bean.GodsBean;
import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.lib_network.bean.BaseResponseBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ProductApiServer {

    @GET
    Observable<BaseResponseBean<List<ShoppignBean>>> requestSPcar(@Url String api, @HeaderMap Map<String, String> parmas);

    @GET
    Observable<BaseResponseBean<GodsBean>> requestGoods(@Url String api, @HeaderMap Map<String, String> parmas, @QueryMap  Map<String, String> parmd);


    @GET
    Observable<DanBean> reqDao(@Url String api,
                               @HeaderMap Map<String,String> params,
                               @QueryMap Map<String,String> paramsBody);
}
