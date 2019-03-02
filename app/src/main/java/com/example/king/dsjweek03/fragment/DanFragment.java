package com.example.king.dsjweek03.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.adapter.DanAdapter;
import com.example.king.dsjweek03.bean.DanBean;
import com.example.king.dsjweek03.contact.DanListContact;
import com.example.king.dsjweek03.presenter.DanListPresenter;
import com.example.lib_core.base.mvp.BaseMvpFragment;
import com.example.lib_core.base.mvp.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DanFragment extends BaseMvpFragment<DanListContact.IDanListModel, DanListContact.IDanListPresenter>
        implements DanListContact.IDanListView {

    @BindView(R.id.dan_all_list)
    ImageView danAllList;
    @BindView(R.id.dan_pay)
    ImageView danPay;
    @BindView(R.id.dan_receive)
    ImageView danReceive;
    @BindView(R.id.dan_comment)
    ImageView danComment;
    @BindView(R.id.dan_finish)
    ImageView danFinish;
    @BindView(R.id.dan_xrecy)
    XRecyclerView danRecy;
    Unbinder unbinder;
    private Map<String, String> paramsBody;
    private Map<String, String> params;
    private DanAdapter danAdapter;

    @Override
    protected int getResLayoutById() {
        return R.layout.fragment_dan;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        //设置适配器
        danRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        danAdapter = new DanAdapter(getActivity());
        danRecy.setAdapter(danAdapter);

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
        paramsBody = new HashMap<>();
        paramsBody.put("status", "0");
        paramsBody.put("page", "1");
        paramsBody.put("count", "5");
        presenter.setDanList(params, paramsBody);
    }

    @Override
    public void onSuccess(List<DanBean.OrderListBean> list) {
        //ToastUtils.showLong("数量"+list.size());
        danAdapter.setList(list);
    }

    @Override
    public void onFile(String msg) {
        ToastUtils.showLong(msg);
    }

    @Override
    public BasePresenter initPresenter() {
        return new DanListPresenter();
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

    @OnClick({R.id.dan_all_list, R.id.dan_pay, R.id.dan_receive, R.id.dan_comment, R.id.dan_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dan_all_list:
                paramsBody.put("status","0");
                presenter.setDanList(params, paramsBody);
                break;
            case R.id.dan_pay:
                paramsBody.put("status","1");
                presenter.setDanList(params, paramsBody);
                break;
            case R.id.dan_receive:
                paramsBody.put("status","2");
                presenter.setDanList(params, paramsBody);
                break;
            case R.id.dan_comment:
                paramsBody.put("status","3");
                presenter.setDanList(params, paramsBody);
                break;
            case R.id.dan_finish:
                paramsBody.put("status","9");
                presenter.setDanList(params, paramsBody);
                break;
        }
    }
}
