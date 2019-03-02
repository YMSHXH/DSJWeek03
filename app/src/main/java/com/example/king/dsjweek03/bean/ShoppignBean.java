package com.example.king.dsjweek03.bean;

import com.example.lib_network.bean.BaseResponseBean;


public class ShoppignBean extends BaseResponseBean {


        /**
         * commodityId : 5
         * commodityName : 双头两用修容笔
         * count : 3
         * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
         * price : 39
         */

        private boolean GoodsisCheck;
        private String commodityId;
        private String commodityName;
        private String count;
        private String pic;
        private String price;

    public boolean isGoodsisCheck() {
        return GoodsisCheck;
    }

    public void setGoodsisCheck(boolean goodsisCheck) {
        GoodsisCheck = goodsisCheck;
    }

    public String getCommodityId() {
            return commodityId;
        }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
