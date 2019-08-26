package com.ethanzyc.allinone;

import com.ethanzyc.allinone.data.mongo.Student;
import com.ethanzyc.allinone.data.mongo.StudentDao;
import com.ethanzyc.allinone.thread.TestThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ethan
 * @date 2019/6/12 14:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void testInsert() {
        Student add = studentDao.add(Student.builder().nickName("ethan1").realName("ZHUYUCHEN").age(23).build());
        System.out.println(add);
    }

}
