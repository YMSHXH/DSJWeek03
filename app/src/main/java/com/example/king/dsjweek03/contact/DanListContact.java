package com.example.king.dsjweek03.contact;

import com.example.king.dsjweek03.bean.DanBean;
import com.example.king.dsjweek03.model.DanListModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.List;
import java.util.Map;
/**
 * 根据订单状态查询订单信息
 */
public interface DanListContact {

    abstract class IDanListPresenter extends BasePresenter<IDanListModel,IDanListView>{

        @Override
        public IDanListModel getModule() {
            return new DanListModel();
        }

        public abstract void setDanList(Map<String,String> params,Map<String,String> paramsBody);
    }

    interface IDanListModel extends IBaseModel{
        void setDanList(Map<String, String> params,
                        Map<String, String> paramsBody,
                        DanListModel.DanListCallBack danListCallBack);
    }

    interface IDanListView extends IBaseView{
        void onSuccess(List<DanBean.OrderListBean> list);
        void onFile(String msg);
    }
}
