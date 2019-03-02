package com.example.king.dsjweek03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.bean.DanBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DanAdapter extends RecyclerView.Adapter<DanAdapter.DanAdapterVH> {

    private Context context;
    private List<DanBean.OrderListBean> list;

    public DanAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    /**
     * 设置数据
     *
     * @param list
     */
    public void setList(List<DanBean.OrderListBean> list) {
        if (list != null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanAdapterVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_dao, viewGroup, false);
        DanAdapterVH danAdapterVH = new DanAdapterVH(inflate);
        return danAdapterVH;
    }

    @Override
    public void onBindViewHolder(@NonNull DanAdapterVH danAdapterVH, int i) {
        DanBean.OrderListBean orderListBean = list.get(i);
        danAdapterVH.expressCompName.setText(orderListBean.getExpressCompName());
        danAdapterVH.orderIdName.setText(orderListBean.getOrderId());
        danAdapterVH.expressSnName.setText(orderListBean.getExpressSn());

        List<DanBean.OrderListBean.DetailListBean> detailList = orderListBean.getDetailList();

        DaoGoodsAdapter daoGoodsAdapter = new DaoGoodsAdapter(context,detailList);
        danAdapterVH.danRecyitem.setLayoutManager(new LinearLayoutManager(context));
        danAdapterVH.danRecyitem.setAdapter(daoGoodsAdapter);

        danAdapterVH.btnGotoPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DanAdapterVH extends RecyclerView.ViewHolder {
        @BindView(R.id.dan_recyitem)
        RecyclerView danRecyitem;
        @BindView(R.id.orderIdName)
        TextView orderIdName;
        @BindView(R.id.expressCompName)
        TextView expressCompName;
        @BindView(R.id.expressSnName)
        TextView expressSnName;
        @BindView(R.id.btn_goto_pay)
        Button btnGotoPay;

        public DanAdapterVH(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
