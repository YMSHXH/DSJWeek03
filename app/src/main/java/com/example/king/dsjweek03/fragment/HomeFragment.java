package com.example.king.dsjweek03.fragment;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.bean.GodsBean;
import com.example.king.dsjweek03.contact.GoodsContact;
import com.example.king.dsjweek03.presenter.GoodsPresenter;
import com.example.lib_core.base.BaseFragment;
import com.example.lib_core.base.mvp.BaseMvpFragment;
import com.example.lib_core.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends BaseMvpFragment<GoodsContact.IGoodsModel,GoodsContact.IGoodsPresenter>
        implements GoodsContact.IGoodsView {
    @Override
    protected int getResLayoutById() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void init() {
        Map<String, String> params = new HashMap<>();
        params.put("userId", "1464");
        params.put("sessionId", "15514902837921464");
        Map<String, String> parad = new HashMap<>();
        parad.put("commodityId","5");
        presenter.setGoodsList(params,parad);
    }

    @Override
    public void onSuccess(GodsBean godsBean) {
        ToastUtils.showLong(godsBean.getCategoryName()+"1231");


    }

    @Override
    public void onFile(String msg) {
        ToastUtils.showLong(msg);
    }

    @Override
    public BasePresenter initPresenter() {
        return new GoodsPresenter();
    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void failLoding(String msg) {

    }
}
