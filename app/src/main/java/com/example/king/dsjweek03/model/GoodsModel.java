package com.example.king.dsjweek03.model;

import android.annotation.SuppressLint;

import com.example.king.dsjweek03.api.ProducetApi;
import com.example.king.dsjweek03.api.ProductApiServer;
import com.example.king.dsjweek03.bean.GodsBean;
import com.example.king.dsjweek03.contact.GoodsContact;
import com.example.lib_network.bean.BaseResponseBean;
import com.example.lib_network.network.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class GoodsModel implements GoodsContact.IGoodsModel {
    @SuppressLint("CheckResult")
    @Override
    public void setGoodsList(Map<String, String> parmas, Map<String, String> parmd, final GoodsModelCallBack goodsModelCallBack) {
        RetrofitUtils.getInstance().createService(ProductApiServer.class)
                .requestGoods(ProducetApi.GOODS_API,parmas,parmd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResponseBean<GodsBean>>() {
                    @Override
                    public void accept(BaseResponseBean<GodsBean> godsBeanBaseResponseBean) throws Exception {
                        if ("0000".equals(godsBeanBaseResponseBean.status)) {
                            goodsModelCallBack.onSuccess(godsBeanBaseResponseBean.result);
                        } else {
                            goodsModelCallBack.onFile(godsBeanBaseResponseBean.message);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        goodsModelCallBack.onFile("网络错误");
                    }
                });
    }

    public interface GoodsModelCallBack{
        void onSuccess(GodsBean godsBean);
        void onFile(String msg);
    }
}
