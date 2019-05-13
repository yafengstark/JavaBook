package com;

import java.io.*;

/**
 *
 * 字节与
 * 字符编码
 * 参考： https://www.cnblogs.com/chenssy/p/4214835.html
 * @author tony
 * @date 2019/5/13 17:05
 */
public class StringDecodeDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\test.txt");
        // 存在一个问题test.txt编码格式为UTF-8，
        // 那么通过字节流读取文件时所获得的数据流编码格式就是UTF-8
        InputStream input = new FileInputStream(file);

        StringBuffer buffer = new StringBuffer();
        byte[] bytes = new byte[1024];
        for(int n ; (n = input.read(bytes))!=-1 ; ){
            buffer.append(new String(bytes,0,n, "UTF-8"));
        }
        System.out.println(buffer);
    }
}
