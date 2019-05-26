package com;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 与Double相关的工具类
 *
 *
 * @author tony
 * @date 2019/5/25 12:21
 */
public class DoubleUtil {

    /**
     * java保留两位小数
     */
    public static void format(){
        DecimalFormat    df   = new DecimalFormat("######0.00");

        double d1 = 3.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));
        System.out.println(df.format(d3));
    }

    /**
     * 四舍五入
     */
    public static void roundUpRoundDown(){
        double   f   =   111231.5585;
        BigDecimal b   =   new   BigDecimal(f);
        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args){
        format();
    }

}
