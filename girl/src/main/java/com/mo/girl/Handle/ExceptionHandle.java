package com.mo.girl.Handle;

import com.mo.girl.Entity.Result;
import com.mo.girl.Enums.ResultEnum;
import com.mo.girl.Exception.GirlException;
import com.mo.girl.Utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 音神
 * @date 2018/10/9 17:45
 */

@ControllerAdvice
/**
 * 类不能和注解名字一样
 *
 * 总之，这个注解能捕获异常
 * 可以理解为catch块
 */
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler
    @ResponseBody
    public Result GirlExceptionHandler(Exception e){
        if(e instanceof GirlException){
            return ResultUtil.failure(((GirlException) e).getCode(), e.getMessage());
        }
        logger.info("[系统错误] {}", e);
        return ResultUtil.failure(ResultEnum.UNKNOWN_ERROR);
    }
}
