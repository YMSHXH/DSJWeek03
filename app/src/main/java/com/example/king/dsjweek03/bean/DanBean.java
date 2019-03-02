package com.example.king.dsjweek03.bean;

import com.example.lib_network.bean.BaseResponseBean;

import java.util.List;

/**
 * 获取订单
 */
public class DanBean {


    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":2,"commodityId":42,"commodityName":"【清仓】浅口尖头中空交叉带单鞋高跟鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/2.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/3.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/4.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/5.jpg","commodityPrice":99,"orderDetailId":25},{"commentStatus":1,"commodityCount":1,"commodityId":111,"commodityName":"三合一充电器数据线苹果二合一拖安卓手机多用功能多头车载苹果安卓一拖三数据线Type-C铝合金编织线 土豪金","commodityPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/1.jpg,http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/2.jpg,http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/3.jpg,http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/4.jpg","commodityPrice":39,"orderDetailId":26}],"expressCompName":"京东快递","expressSn":"1001","orderId":"20190226185114856605","orderStatus":1,"payAmount":237,"payMethod":1,"userId":605},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":101,"commodityName":"vivo X23幻彩版 多套餐 全面屏拍照美颜超大广角摄影水滴屏智能4G 正品vivox23手机","commodityPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/2/1.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/2/2.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/2/3.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/2/4.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/2/5.jpg","commodityPrice":2798,"orderDetailId":15}],"expressCompName":"京东快递","expressSn":"1001","orderId":"20190225150432827605","orderStatus":1,"payAmount":2798,"payMethod":1,"userId":605}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":2,"commodityId":42,"commodityName":"【清仓】浅口尖头中空交叉带单鞋高跟鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/2.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/3.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/4.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/5.jpg","commodityPrice":99,"orderDetailId":25},{"commentStatus":1,"commodityCount":1,"commodityId":111,"commodityName":"三合一充电器数据线苹果二合一拖安卓手机多用功能多头车载苹果安卓一拖三数据线Type-C铝合金编织线 土豪金","commodityPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/1.jpg,http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/2.jpg,http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/3.jpg,http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/4.jpg","commodityPrice":39,"orderDetailId":26}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 20190226185114856605
         * orderStatus : 1
         * payAmount : 237
         * payMethod : 1
         * userId : 605
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private String orderStatus;
        private String payAmount;
        private String payMethod;
        private String userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(String payMethod) {
            this.payMethod = payMethod;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 2
             * commodityId : 42
             * commodityName : 【清仓】浅口尖头中空交叉带单鞋高跟鞋
             * commodityPic : http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/2.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/3.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/4.jpg,http://172.17.8.100/images/small/commodity/nx/ggx/4/5.jpg
             * commodityPrice : 99
             * orderDetailId : 25
             */

            private String commentStatus;
            private String commodityCount;
            private String commodityId;
            private String commodityName;
            private String commodityPic;
            private String commodityPrice;
            private String orderDetailId;

            public String getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(String commentStatus) {
                this.commentStatus = commentStatus;
            }

            public String getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(String commodityCount) {
                this.commodityCount = commodityCount;
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

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public String getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(String commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public String getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(String orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
