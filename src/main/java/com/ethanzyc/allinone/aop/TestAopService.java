package com.ethanzyc.allinone.aop;

import com.ethanzyc.allinone.jpa.User;
import com.ethanzyc.allinone.jpa.User2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @date 2019/7/24 11:30
 */
@Service
@Slf4j
public class TestAopService {

    @RedisCache(type = "1")
    public User getUser(Params params) {

        log.info("user参数：{}", params);
        User user1 = User.builder().email("xxx111").id(999).build();
        return user1;
    }

    @RedisCache(type = "2")
    public User2 getUser2(Params params) {

        log.info("user参数：{}", params);
        User2 user1 = User2.builder().userEmail("xxx111").age(999).build();
        return user1;
    }
}
