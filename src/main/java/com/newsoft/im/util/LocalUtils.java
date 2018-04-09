package com.newsoft.im.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 * @create 2018-03-24 23:57
 * Description: 本地工具类
 */
public class LocalUtils {
    /**
     * 获取当前系统8位日期
     * @return
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 字符串判空，空返回true，不空返回false
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null && !"".equals(str) && str.length() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
