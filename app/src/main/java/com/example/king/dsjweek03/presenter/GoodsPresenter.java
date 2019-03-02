package com.example.king.dsjweek03.presenter;

import com.example.king.dsjweek03.bean.GodsBean;
import com.example.king.dsjweek03.contact.GoodsContact;
import com.example.king.dsjweek03.model.GoodsModel;

import java.util.Map;

public class GoodsPresenter extends GoodsContact.IGoodsPresenter {

    @Override
    public void setGoodsList(Map<String, String> parmas, Map<String, String> parmd) {
        modle.setGoodsList(parmas, parmd, new GoodsModel.GoodsModelCallBack() {
            @Override
            public void onSuccess(GodsBean godsBean) {
                view.onSuccess(godsBean);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}