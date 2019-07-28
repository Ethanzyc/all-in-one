package com.ethanzyc.allinone.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ethan
 * @date 2019/7/26 21:25
 */
@RestController
@RequestMapping("user")
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String getUsers() {
        return "success";
    }

}
