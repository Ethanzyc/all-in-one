package com.ethanzyc.allinone;

import com.ethanzyc.allinone.jpa.User;
import com.ethanzyc.allinone.jpa.UserMapper;
import com.ethanzyc.allinone.jpa.UserRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ethan
 * @date 2019/7/8 09:08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageHelperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        PageHelper.startPage(1, 10);
        Page<User> user = userMapper.getUser();
        List<User> result = user.getResult();
        System.out.println(result);
    }
}
