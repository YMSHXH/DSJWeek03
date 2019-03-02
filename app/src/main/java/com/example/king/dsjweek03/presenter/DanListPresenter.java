package com.example.king.dsjweek03.presenter;

import com.example.king.dsjweek03.bean.DanBean;
import com.example.king.dsjweek03.contact.DanListContact;
import com.example.king.dsjweek03.model.DanListModel;

import java.util.List;
import java.util.Map;

public class DanListPresenter extends DanListContact.IDanListPresenter {
    @Override
    public void setDanList(Map<String, String> params, Map<String, String> paramsBody) {
        modle.setDanList(params, paramsBody, new DanListModel.DanListCallBack() {
            @Override
            public void onSuccess(List<DanBean.OrderListBean> list) {
                view.onSuccess(list);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}
