package com;

import java.text.DecimalFormat;

/**
 * 与Double相关的工具类
 *
 *
 * @author tony
 * @date 2019/5/25 12:21
 */
public class DoubleUtil {

    public static void format(){
        DecimalFormat    df   = new DecimalFormat("######0.00");

        double d1 = 3.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));
        System.out.println(df.format(d3));


    }

    public static void main(String[] args){
        format();
    }

}
