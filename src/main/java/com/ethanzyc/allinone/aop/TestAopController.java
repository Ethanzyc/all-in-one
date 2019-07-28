package com.ethanzyc.allinone.aop;

import com.ethanzyc.allinone.jpa.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ethan
 * @date 2019/7/24 11:29
 */
@RestController
@RequestMapping("aop")
@PreAuthorize("hasRole('admin')")
//@PreAuthorize("hasRole('visitor')")
public class TestAopController {

    @Autowired
    private TestAopService testAopService;

    @RequestMapping("test")
    public String getUser(@RequestBody Params params) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        val user = authentication.getPrincipal();
        System.out.println(user);

        return "111";
    }
}
