package com.example.king.dsjweek03.presenter;

import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.king.dsjweek03.contact.ShoppingContact;
import com.example.king.dsjweek03.model.ShoppingModel;

import java.util.List;
import java.util.Map;

public class ShoppingPresenter extends ShoppingContact.IShoppingPresenter {
    @Override
    public void setShoppingList(Map<String, String> parmas) {
        modle.setShoppingList(parmas, new ShoppingModel.ShoppingModelCallBack() {
            @Override
            public void onSuccess(List<ShoppignBean> list) {
                view.onSuccess(list);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}
