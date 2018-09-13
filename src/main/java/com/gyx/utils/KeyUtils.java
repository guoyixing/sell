package com.gyx.utils;

import java.util.Random;

/**
 * @author gyx
 * @date 2018-05-30 13:47
 * @since 1.0.0
 */
public class KeyUtils {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }


}
