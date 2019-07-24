package com.ethanzyc.allinone.aop;

import com.alibaba.fastjson.JSON;
import com.ethanzyc.allinone.jpa.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author ethan
 * @date 2019/7/24 11:37
 */
@Slf4j
@Aspect
@Component
public class RedisAspect {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Pointcut("@annotation(com.ethanzyc.allinone.aop.RedisCache)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("RedisAspect before");

    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("RedisAspect after");
    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Object[] args = point.getArgs();
        log.info("before args:{}", args);
        if (args.length == 1) {

            Method method = ((MethodSignature) point.getSignature()).getMethod();
            RedisCache cache = method.getAnnotation(RedisCache.class);
            String type = cache.type();
            if (StringUtils.equals(type, "1")) {
                Params params = (Params) args[0];
                String key = Util.generateKey(params);
                String result = redisTemplate.opsForValue().get(key);
                if (StringUtils.isNotBlank(result)) {
                    return JSON.parseObject(result, method.getReturnType());
                } else {
                    Object proceed = point.proceed();

                    log.info("return:{}", proceed);

                    String data = JSON.toJSONString(proceed);
                    redisTemplate.opsForValue().set(key, data);
                    redisTemplate.expire(key, 1, TimeUnit.DAYS);

                    return proceed;
                }
            }
        }


        throw new Exception();

    }
}
