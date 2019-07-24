package com.ethanzyc.allinone.aop;

import java.lang.annotation.*;

/**
 * @author ethan
 * @date 2019/7/24 11:38
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
    String type();
}
