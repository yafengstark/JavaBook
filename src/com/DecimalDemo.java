package com;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 *由于需要处理精度比较高的浮点数，所以弃用double类型，改用BigDecimal类来进行数值处理。
 *
 * 特别注意除法运算
 * 
 *
 *
 * @author tony
 * @date 2019/7/8 21:51
 */
public class DecimalDemo {

    public static void main(String[] args){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        try {

            BigDecimal x1 = BigDecimal.valueOf(simpleDateFormat.parse("19490304").getTime());
            BigDecimal x2 = BigDecimal.valueOf(simpleDateFormat.parse("19960716").getTime());

            BigDecimal y1 = BigDecimal.valueOf(997988);
            BigDecimal y2 = BigDecimal.valueOf(1022192);

            BigDecimal k = (y2.subtract(y1)).divide(x2.subtract(x1),100,ROUND_HALF_DOWN);

            BigDecimal  b =  y1.subtract( k.multiply(x1));

            System.out.println(k + "\n" +b);

            BigDecimal x3 = BigDecimal.valueOf(simpleDateFormat.parse("20050801").getTime());
            System.out.println("第三点差值："+(k.multiply(x3).add(b)).subtract(BigDecimal.valueOf(1026817)));

            System.out.println(
                    y2.subtract(y1).divide(x2.subtract(x1),1000,ROUND_HALF_DOWN).multiply(x3.subtract(x1)).add(y1)
            );

            BigDecimal x4 = BigDecimal.valueOf(simpleDateFormat.parse("20100719").getTime());
            System.out.println("第四点差值："+(k.multiply(x4).add(b)).subtract(BigDecimal.valueOf(1029363)));

            BigDecimal x5 = BigDecimal.valueOf(simpleDateFormat.parse("20140607").getTime());
            System.out.println("第五点差值："+(k.multiply(x5).add(b)).subtract(BigDecimal.valueOf(1031367)));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
