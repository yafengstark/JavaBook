package com.du;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Raw> raw11List = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/tongyanfeng/Downloads/13.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {

                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分


                Raw raw = new Raw();
                raw.商品名称 = item[0];
                raw.货号 = item[1];
                raw.码段 = item[2];
                raw.数量 = item[3];
                raw.箱号 = item[4];
                raw.快递单号 = item[5];

                raw11List.add(raw);

                System.out.println(raw.货号 + ":" + raw.码段);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("csv1: "+ raw11List.size());

        List<Raw> raw12List = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/tongyanfeng/Downloads/13-1.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {

                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分


                Raw raw = new Raw();
                raw.商品名称 = item[0];
                raw.货号 = item[1];
                raw.码段 = item[2];
                raw.数量 = item[3];
                raw.箱号 = item[4];
                raw.快递单号 = item[5];

                raw12List.add(raw);

                System.out.println(raw.货号 + ":" + raw.码段);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("csv2: " +raw12List.size());

        // -----------
        List<Result> resultList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/tongyanfeng/Downloads/result-13.csv"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {

                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分

                Result raw = new Result();
                raw.订单编号 = item[0];
                raw.商品名称 = item[1];
                raw.货号 = item[2];
                raw.尺码 = item[3];
                raw.价格 = item[4];
                raw.下单时间 = item[5];
                raw.状态 = item[6];
//                raw.运单号 = item[7];

                resultList.add(raw);

                System.out.println(raw.货号 + ":" + raw.尺码);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultList.size());

        raw11List.addAll(raw12List);
        for (Result result : resultList) {
//            System.out.println("\t"+ result.货号 +"\t"+result.尺码);

            result.尺码 = result.尺码.replace("码", "");

//            System.out.println("\t"+ result.货号 +"\t"+result.尺码);

            boolean has = false;

            for (Raw raw : raw11List) {

//                System.out.println("\t"+ raw.货号 +"\t"+raw.码段);

                if (result.货号.trim().equalsIgnoreCase(raw.货号.trim())
                        && result.尺码.trim().equalsIgnoreCase(raw.码段.trim())) {
                    result.运单号 = raw.快递单号;
//                    if(result.新运单号.equalsIgnoreCase(result.运单号)){
//                        result.是否相同 = "相同";
//                    }else{
//                        result.是否相同 = "不相同";
//                    }

                    has = true;
//                    System.out.println("change11");
                }


            }


            if (!has) {
                result.运单号 = "无法匹配";

            }

            System.out.println(result.toString());

        }


    }


}
