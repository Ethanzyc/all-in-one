package com.ethanzyc.allinone.testError.exception;

/**
 * @author ethan
 * @date 2019/6/24 23:19
 */
public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
