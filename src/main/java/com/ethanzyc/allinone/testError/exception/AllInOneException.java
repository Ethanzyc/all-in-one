package com.ethanzyc.allinone.testError.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author ethan
 * @date 2019/7/30 08:22
 */
@ControllerAdvice
public class AllInOneException extends ExceptionCatch {

    static {
        builder.put(AccessDeniedException.class, CommonCode.UNAUTHORISE);
    }
}
