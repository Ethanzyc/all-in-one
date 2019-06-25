package com.ethanzyc.allinone.testError.exception;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ethan
 * @date 2019/6/24 23:44
 */
@ControllerAdvice
public class ExceptionCatch {

    // 定义map，配置异常类型所对应的错误代码
    // ImmutableMap 不可更改
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    // 构建map
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException) {
        System.out.println("---------customException---------");
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        System.out.println("---------exception---------");

        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        // 从异常类型找对应的
        ResultCode code = EXCEPTIONS.get(exception.getClass());
        if (code != null) {
            return new ResponseResult(code);
        }


        ResultCode resultCode = CommonCode.SERVER_ERROR;
        return new ResponseResult(resultCode);
    }

    static {
        builder.put(NullPointerException.class, CommonCode.NULL_POINT);
    }
}
