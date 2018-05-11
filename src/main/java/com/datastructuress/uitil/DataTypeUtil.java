package com.datastructuress.uitil;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author dongyl
 * @date 18:18 5/7/18
 * @project study-demo
 */
public class DataTypeUtil {
    private static final int DEF_DIV_SCALE = 10;

    public static double doubleAdd(double v1, double v2) {

        BigDecimal b1 = new BigDecimal(Double.valueOf(v1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(v2));
        return b1.add(b2).doubleValue();
    }

    public static double doubleSub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(v1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double doubleMul(double v1, double v2) {
        return doubleDiv(v1, v2, DEF_DIV_SCALE);

    }

    public static double doubleDiv(double v1, double v2) {
        return doubleDiv(v1,v2,DEF_DIV_SCALE);
    }

    public static double doubleDiv(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(v1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(v2));
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static double doubleRound(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        double dble1 = Math.random();
        double dble2 = Math.random();
        System.out.println("dble1 :" +dble1);
        System.out.println("dble2 :" +dble2);
        double xx = doubleDiv(dble1, dble2);
        System.out.println("dble1 / dble2 :" +dble1 / dble2);
        System.out.println("xx :" +xx);

    }

    private static String byte2String(byte b) {
        String str = String.valueOf(b);
        return str;
    }

    private static long double2Long(double d) {
        long l = Double.doubleToLongBits(d);
        System.out.println("l: " + l);
        return l;
    }

    private static String long2String(long b) {

        String str = String.valueOf(b);
        return str;
    }

    /**
     * 获取变量类型方法
     *
     * @param o
     * @return
     */
    public static String getType(Object o) {
        //使用int类型的getClass()方法
        return o.getClass().toString();
    }
}
