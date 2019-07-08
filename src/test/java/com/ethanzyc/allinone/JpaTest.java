package com.ethanzyc.allinone;

import com.ethanzyc.allinone.jpa.User;
import com.ethanzyc.allinone.jpa.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * JPA 的增删改查
 * 只要集成 extends CrudRepository<?, ?> 就可以
 * 第一个问号是实体类名，第二个问号是主键类型
 *
 * @author ethan
 * @date 2019/7/7 00:08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 增
     */
    @Test
    public void testAdd() {
        for (int i = 0; i < 36; i++) {
            User user = new User();
            user.setEmail("ethan@gmail.com" + i);
            user.setName("ethan" + i);
            userRepository.save(user);
        }
    }

    /**
     * 删
     */
    @Test
    public void testDelete() {
        User user = new User();
        user.setId(1);
        userRepository.delete(user);
    }

    /**
     * 改
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setName("zhuyuchen111");
        userRepository.save(user);
    }

    /**
     * 查 一个
     */
    @Test
    public void testSelectById() {
        Optional<User> userOptional = userRepository.findById(3);
        if (userOptional.isPresent()) {
            log.info(userOptional.get().toString());
        } else {
            log.info("id为3的没查到");
        }
    }

    /**
     * 查 列表
     */
    @Test
    public void testSelectList() {
        Iterable<User> all = userRepository.findAll();
        all.forEach(item -> {
            log.info(item.toString());
        });
    }
}
