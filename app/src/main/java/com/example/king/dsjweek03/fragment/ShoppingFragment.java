package com.example.king.dsjweek03.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.presenter.ShoppingPresenter;
import com.example.king.dsjweek03.adapter.ShoppingAdapter;
import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.king.dsjweek03.contact.ShoppingContact;
import com.example.lib_core.base.mvp.BaseMvpFragment;
import com.example.lib_core.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShoppingFragment extends BaseMvpFragment<ShoppingContact.IShoppingModel, ShoppingContact.IShoppingPresenter>
        implements ShoppingContact.IShoppingView ,ShoppingAdapter.ShoppingAdapterCallBack,ShoppingAdapter.toGoods {
    @BindView(R.id.xrecyView)
    RecyclerView recyView;
    @BindView(R.id.ckb_quan)
    CheckBox ckbQuan;
    @BindView(R.id.ckb_sum)
    TextView ckbSum;
    @BindView(R.id.go_pay)
    TextView goPay;
    Unbinder unbinder;
    private List<ShoppignBean> listq;
    private ShoppingAdapter shoppingAdapter;
    private GoodsIdCallBack goodsIdCallBack;
    private toDanCallBack toDanCallBack;

    public void setToDanCallBack(ShoppingFragment.toDanCallBack toDanCallBack) {
        this.toDanCallBack = toDanCallBack;
    }

    public void setGoodsIdCallBack(GoodsIdCallBack goodsIdCallBack) {
        this.goodsIdCallBack = goodsIdCallBack;
    }

    @Override
    protected int getResLayoutById() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        recyView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        ckbQuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                for (ShoppignBean shoppignBean : listq) {
//                    shoppignBean.setGoodsisCheck(isChecked);
//                }
//                shoppingAdapter.notifyDataSetChanged();
//                sumPrice();
//            }
//        });

        ckbQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ckbQuan.isChecked();
                for (ShoppignBean shoppignBean : listq) {
                    shoppignBean.setGoodsisCheck(checked);
                }
                shoppingAdapter.notifyDataSetChanged();
                sumPrice();
            }
        });

        goPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到订单
                toDanCallBack.toDan();
            }
        });
    }

    /**
     * 计算价格
     */
    private void sumPrice() {
        double sum_price = 0;
        for (ShoppignBean shoppignBean : listq) {
            if (shoppignBean.isGoodsisCheck()){
                double price = Double.parseDouble(shoppignBean.getPrice());
                int count = Integer.parseInt(shoppignBean.getCount());
                sum_price +=  price * count ;
            }
        }
        ckbSum.setText("合计 ￥：" + sum_price);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void init() {
        listq = new ArrayList<>();

        Map<String, String> params = new HashMap<>();
        params.put("userId", "1464");
        params.put("sessionId", "15514902837921464");
        presenter.setShoppingList(params);
    }

    @Override
    public void onSuccess(List<ShoppignBean> list) {
        listq = list;
        //ToastUtils.showLong(list.size()+"购物车");
        shoppingAdapter = new ShoppingAdapter(getActivity(),list);
        recyView.setAdapter(shoppingAdapter);
        shoppingAdapter.setShoppingAdapterCallBack(this);
        shoppingAdapter.setToGoods(this);
    }

    @Override
    public void onFile(String msg) {
        ToastUtils.showLong(msg);

    }

    @Override
    public BasePresenter initPresenter() {
        return new ShoppingPresenter();
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

    @Override
    public void notifyData(boolean isChecked) {

        //判断是否全选
        boolean isAllCheck = true;
        for (ShoppignBean shoppignBean : listq) {
            if (!shoppignBean.isGoodsisCheck()){
                ckbQuan.setChecked(false);
                isAllCheck = false;
            }
        }
        if (isAllCheck) {
            ckbQuan.setChecked(isChecked);
        }
        sumPrice();
    }

    @Override
    public void notifyDataNum() {
        sumPrice();
    }

    @Override
    public void setGoodsId(int position) {
        goodsIdCallBack.toID(listq.get(position).getCommodityId());
    }

    public interface GoodsIdCallBack{
        void toID(String id);
    }

    public interface toDanCallBack{
        void toDan();
    }
}
