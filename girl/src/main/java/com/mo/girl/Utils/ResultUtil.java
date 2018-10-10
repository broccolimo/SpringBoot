package com.mo.girl.Utils;

import com.mo.girl.Entity.Result;
import com.mo.girl.Enums.ResultEnum;

/**
 * @author 音神
 * @date 2018/10/9 17:18
 */

/**
 * 消除冗余
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result failure(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        result.setData(null);
        return result;
    }

    public static Result failure(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }
}
