package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 参考：https://www.cnblogs.com/30go/p/7200739.html
 *
 * 只使用log4j v1.x.x版本，不要实用v2.x.x版本，差别较大。
 *
 * @author tony
 * @date 2019/5/26 10:11
 */
public class LoggerDemo {

    private static Logger logger = LoggerFactory.getLogger(LoggerDemo.class);

    public static void main(String[] args){
        logger.debug("你好");
        logger.warn("warning message ...");
        logger.error("error message ...");
        logger.error("error message ...");
    }
}
