package com.example.king.dsjweek03.model;

import android.annotation.SuppressLint;

import com.example.king.dsjweek03.api.ProducetApi;
import com.example.king.dsjweek03.api.ProductApiServer;
import com.example.king.dsjweek03.bean.DanBean;
import com.example.king.dsjweek03.contact.DanListContact;
import com.example.lib_network.network.RetrofitUtils;


import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DanListModel implements DanListContact.IDanListModel {

    @SuppressLint("CheckResult")
    @Override
    public void setDanList(Map<String, String> params, Map<String, String> paramsBody, final DanListCallBack danListCallBack) {
        RetrofitUtils.getInstance().createService(ProductApiServer.class)
                .reqDao(ProducetApi.DAN_API,params,paramsBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DanBean>() {
                    @Override
                    public void accept(DanBean danBean) {
                        if("0000".equals(danBean.getStatus())){
                            danListCallBack.onSuccess(danBean.getOrderList());
                        } else {
                            danListCallBack.onFile(danBean.getMessage());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        danListCallBack.onFile("网络错误");
                    }
                });
    }

    public interface DanListCallBack{
        void onSuccess(List<DanBean.OrderListBean> list);
        void onFile(String msg);
    }
}
