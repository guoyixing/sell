package com.gyx.utils;

/**
 * @author gyx
 * @date 2018-06-04 16:14
 * @since 1.0.0
 */
public class MathUtil {

    private static final Double Money_Range = 0.01;

    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        return result<Money_Range;
    }
}
