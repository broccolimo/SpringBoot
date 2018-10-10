package com.mo.girl.Exception;

import com.mo.girl.Enums.ResultEnum;

/**
 * @author 音神
 * @date 2018/10/9 21:16
 */

public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum e) {
        super(e.getMsg());
        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
