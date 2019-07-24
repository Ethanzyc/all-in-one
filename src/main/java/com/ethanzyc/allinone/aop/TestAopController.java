package com.ethanzyc.allinone.aop;

import com.ethanzyc.allinone.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ethan
 * @date 2019/7/24 11:29
 */
@RestController
@RequestMapping("aop")
public class TestAopController {

    @Autowired
    private TestAopService testAopService;

    @RequestMapping("test")
    public User getUser(@RequestBody Params params) {
        return testAopService.getUser(params);
    }
}
