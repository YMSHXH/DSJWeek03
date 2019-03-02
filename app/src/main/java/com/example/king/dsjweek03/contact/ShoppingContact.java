package com.example.king.dsjweek03.contact;

import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.king.dsjweek03.model.ShoppingModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.List;
import java.util.Map;

public interface ShoppingContact {

    abstract class IShoppingPresenter extends BasePresenter<IShoppingModel,IShoppingView>{

        @Override
        public IShoppingModel getModule() {
            return new ShoppingModel();
        }

        public abstract void setShoppingList(Map<String, String> parmas);
    }

    interface IShoppingModel extends IBaseModel {
        void setShoppingList(Map<String, String> parmas, ShoppingModel.ShoppingModelCallBack shoppingModelCallBack);
    }

    interface IShoppingView extends IBaseView {
        void onSuccess(List<ShoppignBean> list);
        void onFile(String msg);
    }
}
