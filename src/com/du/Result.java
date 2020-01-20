package com.du;

public class Result {
    String 订单编号;
    String 商品名称;
    String 货号;
    String 尺码;
    String 价格;
    String 下单时间;
    String 状态;
    String 运单号;

    public String toString() {
        return 订单编号 + "," + 商品名称 + "," + 货号 + "," + 尺码 + "," + 价格 + "," + 下单时间
                + "," + 状态 + "," + 运单号;
    }
}
