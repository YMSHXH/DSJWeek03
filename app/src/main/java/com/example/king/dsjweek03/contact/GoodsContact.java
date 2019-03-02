package com.example.king.dsjweek03.contact;

import com.example.king.dsjweek03.bean.GodsBean;
import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.king.dsjweek03.model.GoodsModel;
import com.example.king.dsjweek03.model.ShoppingModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.List;
import java.util.Map;

public interface GoodsContact {

    abstract class IGoodsPresenter extends BasePresenter<IGoodsModel,IGoodsView>{
         @Override
         public IGoodsModel getModule() {
             return new GoodsModel();
         }

         public abstract void setGoodsList(Map<String, String> parmas,Map<String, String> parmd);
    }

    interface IGoodsModel extends IBaseModel {
        void setGoodsList(Map<String, String> parmas,Map<String, String> parmd,GoodsModel.GoodsModelCallBack goodsModelCallBack);
    }

    interface IGoodsView extends IBaseView {
        void onSuccess(GodsBean godsBean);
        void onFile(String msg);
    }
}
