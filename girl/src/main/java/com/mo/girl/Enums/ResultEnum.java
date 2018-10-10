package com.mo.girl.Enums;

/**
 * @author 音神
 * @date 2018/10/9 21:18
 */
//枚举的作用是实现定义好让code和msg一一对应
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "系统错误"),
    SUCCESS(0, "成功"),
    AGE_LEVEL_1(100, "太小了"),
    AGE_LEVEL_2(101, "还是小"),
    AGE_LEVEL_3(102, "可以了"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
