package com.example.king.dsjweek03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.king.dsjweek03.R;
import com.example.king.dsjweek03.bean.GodsBean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsAdapterVH> {

    private Context context;
    private GodsBean godsBean;

    public GoodsAdapter(Context context, GodsBean godsBean) {
        this.context = context;
        this.godsBean = godsBean;
    }

    @NonNull
    @Override
    public GoodsAdapterVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_goodsdeg, viewGroup, false);
        GoodsAdapterVH goodsAdapterVH = new GoodsAdapterVH(inflate);
        return goodsAdapterVH;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsAdapterVH goodsAdapterVH, int i) {
        String picture = godsBean.getPicture();
        final String[] split = picture.split(",");
        List<String> list = new ArrayList<>();
        for (int j = 0; j < split.length; j ++ ){
            list.add(split[j]);
        }
        //加载本地网页
        goodsAdapterVH.webV.loadData(godsBean.getDetails(),
                "text/html; charset=UTF-8",
                null);

        goodsAdapterVH.imageBanner.setData(list,null);
        goodsAdapterVH.imageBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(context).load(split[position]).into((ImageView) view);
            }
        });
        goodsAdapterVH.detailsName.setText(godsBean.getCommodityName());
        goodsAdapterVH.detailsPrice.setText("￥："+godsBean.getPrice());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class GoodsAdapterVH extends RecyclerView.ViewHolder {
        @BindView(R.id.image_banner)
        XBanner imageBanner;
        @BindView(R.id.details_price)
        TextView detailsPrice;
        @BindView(R.id.details_name)
        TextView detailsName;
        @BindView(R.id.webV)
        WebView webV;
        public GoodsAdapterVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
