package com.example.king.dsjweek03.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.bean.ShoppignBean;
import com.example.king.dsjweek03.weight.AddView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingAdapterVH> {

    private Context context;
    private List<ShoppignBean> list;
    private ShoppingAdapterCallBack shoppingAdapterCallBack;
    private toGoods toGoods;

    public void setToGoods(ShoppingAdapter.toGoods toGoods) {
        this.toGoods = toGoods;
    }

    public void setShoppingAdapterCallBack(ShoppingAdapterCallBack shoppingAdapterCallBack) {
        this.shoppingAdapterCallBack = shoppingAdapterCallBack;
    }

    public ShoppingAdapter(Context context, List<ShoppignBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ShoppingAdapterVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_shoppingcar, viewGroup, false);
        ShoppingAdapterVH shoppingAdapterVH = new ShoppingAdapterVH(inflate);
        return shoppingAdapterVH;
    }

    @Override
    public void onBindViewHolder(@NonNull final ShoppingAdapterVH shoppingAdapterVH, final int i) {
        final ShoppignBean shoppignBean = list.get(i);
        for (ShoppignBean bean : list) {
            bean.setCount("1");
        }
        shoppingAdapterVH.goodsCarCkb.setChecked(shoppignBean.isGoodsisCheck());
        shoppingAdapterVH.ckbGoodsCarName.setText(shoppignBean.getCommodityName());
        shoppingAdapterVH.ckbGoodsCarPrace.setText("￥："+shoppignBean.getPrice());
        shoppingAdapterVH.goodsCarImg.setImageURI(Uri.parse(shoppignBean.getPic()));

        shoppingAdapterVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toGoods.setGoodsId(i);
            }
        });

        shoppingAdapterVH.goodsCarCkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = shoppingAdapterVH.goodsCarCkb.isChecked();
                shoppignBean.setGoodsisCheck(checked);
                if (shoppingAdapterCallBack !=null){
                    shoppingAdapterCallBack.notifyData(checked);
                }

            }
        });

        //计算数量
        shoppingAdapterVH.addView.setAddMinusCallback(new AddView.AddMinusCallback() {
            @Override
            public void numCallback(int num) {
                shoppignBean.setCount(num + "");
                if (shoppingAdapterCallBack !=null){
                    shoppingAdapterCallBack.notifyDataNum();
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShoppingAdapterVH extends RecyclerView.ViewHolder {
        @BindView(R.id.goodsCar_ckb)
        CheckBox goodsCarCkb;
        @BindView(R.id.goodsCar_img)
        SimpleDraweeView goodsCarImg;
        @BindView(R.id.ckb_goodsCar_name)
        TextView ckbGoodsCarName;
        @BindView(R.id.ckb_goodsCar_Prace)
        TextView ckbGoodsCarPrace;
        @BindView(R.id.addView)
        AddView addView;
        public ShoppingAdapterVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ShoppingAdapterCallBack{
        void notifyData(boolean isChecked);
        void notifyDataNum();
    }

    public interface toGoods{
        void setGoodsId(int position);
    }
}
