package com.ethanzyc.allinone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ethanzyc.allinone.jpa.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author ethan
 * @date 2019/7/12 14:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis() {
        User user = User.builder().id(111).email("aaa12312@123.com").name("ethan").build();

        String s = JSON.toJSONString(user);

        redisTemplate.opsForValue().set("ethan", s);
        redisTemplate.expire("ethan", 1, TimeUnit.DAYS);
    }

    @Test
    public void testReadRedis() {
        String ethan = redisTemplate.opsForValue().get("ethan");

        User user = JSON.parseObject(ethan, User.class);
        System.out.println(user);
    }
}
