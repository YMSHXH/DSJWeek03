package com.example.king.dsjweek03.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.adapter.GoodsAdapter;
import com.example.king.dsjweek03.bean.GodsBean;
import com.example.king.dsjweek03.contact.GoodsContact;
import com.example.king.dsjweek03.presenter.GoodsPresenter;
import com.example.lib_core.base.mvp.BaseMvpFragment;
import com.example.lib_core.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseMvpFragment<GoodsContact.IGoodsModel, GoodsContact.IGoodsPresenter>
        implements GoodsContact.IGoodsView {
    @BindView(R.id.recyView)
    RecyclerView recyView;
    Unbinder unbinder;
    private Map<String, String> params;
    private Map<String, String> parad;

    @Override
    protected int getResLayoutById() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        recyView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void init() {
        params = new HashMap<>();
        params.put("userId", "1464");
        params.put("sessionId", "15514902837921464");
        parad = new HashMap<>();
        parad.put("commodityId", "5");
        presenter.setGoodsList(params, parad);
    }

    @Override
    public void onSuccess(GodsBean godsBean) {
        //ToastUtils.showLong(godsBean.getCategoryName()+"12312");
        GoodsAdapter goodsAdapter = new GoodsAdapter(getActivity(),godsBean);
        recyView.setAdapter(goodsAdapter);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public void getActivityData(String id){
        //ToastUtils.showLong(id);
        parad.put("commodityId", id);
        presenter.setGoodsList(params, parad);
    }
}
