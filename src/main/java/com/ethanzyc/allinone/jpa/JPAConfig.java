package com.github.ethanzyc.fastSpringBoot.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.Random;

/**
 * @author ethan
 * @date 2019/7/7 10:24
 */
@Configuration
public class JPAConfig implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        /**
         * 这里需要获取登陆人的id，然后赋值给加了@CreatedBy/@LastModifiedBy的字段，暂时测试先写死为1
         */
        Random random = new Random();
        return Optional.of(random.nextInt());
    }
}
