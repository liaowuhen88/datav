package com.example.demo.utils;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * Created by liaowuhen on 2018/1/4.
 */
public class MathUtils {
    public static String  getString(Double dob){
        BigDecimal bd = new BigDecimal(dob);
        return bd.toPlainString();
    }


    public static String  getDivide(String dob){
        if(!StringUtils.isEmpty(dob)){
            BigDecimal a1 = new BigDecimal(dob);
            BigDecimal b1 = new BigDecimal("10000");
            BigDecimal result = a1.divide(b1);// 相乘结果
            return result.toPlainString();
        }

        return null;
    }


    /**
     * 乘10000 获取整数
     * 4位有效数字
     * @param
     * @return
     */
    public static BigDecimal add(String d1,String d2) {
        BigDecimal a1 = new BigDecimal(d1);
        BigDecimal b1 = new BigDecimal(d2);
        BigDecimal result = a1.add(b1);// 相乘结果

        return result;
    }

    public static String add(String... args) {
        BigDecimal result = new BigDecimal(0);
        for(String temp:args){
            if(!StringUtils.isEmpty(temp)){
                BigDecimal b1 = new BigDecimal(temp);
                result = result.add(b1);
            }
        }
        return result.toPlainString();
    }



}
