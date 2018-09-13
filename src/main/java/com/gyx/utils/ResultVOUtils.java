package com.gyx.utils;

import com.gyx.vo.ResultVO;

/**
 * @author gyx
 * @date 2018-05-29 14:00
 * @since 1.0.0
 */
public class ResultVOUtils {
    public static ResultVO success(Object o){
        return new ResultVO(){
            {
                setData(o);
                setMsg("成功");
                setCode(0);
            }
        };
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer core,String msg){
        return new ResultVO(){
            {
                setMsg(msg);
                setCode(core);
            }
        };
    }
}
