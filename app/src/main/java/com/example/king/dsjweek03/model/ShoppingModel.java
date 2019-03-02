package com.example.king.dsjweek03.model;

import android.annotation.SuppressLint;

import com.example.king.dsjweek03.api.ProducetApi;
import com.example.king.dsjweek03.api.ProductApiServer;
import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.king.dsjweek03.contact.ShoppingContact;
import com.example.lib_network.bean.BaseResponseBean;
import com.example.lib_network.network.RetrofitUtils;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ShoppingModel implements ShoppingContact.IShoppingModel {


    @SuppressLint("CheckResult")
    @Override
    public void setShoppingList(Map<String, String> parmas, final ShoppingModelCallBack shoppingModelCallBack) {
        RetrofitUtils.getInstance().createService(ProductApiServer.class)
                .requestSPcar(ProducetApi.SHOPPING_API,parmas)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResponseBean<List<ShoppignBean>>>() {
                    @Override
                    public void accept(BaseResponseBean<List<ShoppignBean>> listBaseResponseBean) throws Exception {
                        if ("0000".equals(listBaseResponseBean.status)){
                            shoppingModelCallBack.onSuccess(listBaseResponseBean.result);
                        } else {
                            shoppingModelCallBack.onFile(listBaseResponseBean.message);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        shoppingModelCallBack.onFile("购物车网络错误!!!");

                    }
                });
    }

    public interface ShoppingModelCallBack{
        void onSuccess(List<ShoppignBean> list);
        void onFile(String msg);
    }
}
