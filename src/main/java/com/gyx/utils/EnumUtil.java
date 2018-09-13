package com.gyx.utils;

import com.gyx.enums.CodeEnum;

/**
 * @author gyx
 * @date 2018-06-06 09:59
 * @since 1.0.0
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
