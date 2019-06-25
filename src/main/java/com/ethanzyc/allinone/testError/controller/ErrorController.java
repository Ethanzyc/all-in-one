package com.ethanzyc.allinone.testError.controller;

import com.ethanzyc.allinone.testError.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ethan
 * @date 2019/6/24 23:14
 */
@RestController
public class ErrorController {

    @Autowired
    private ErrorService errorService;

    @RequestMapping("/test/exception")
    public String test() {
        return "success";
    }

    @RequestMapping("/test/exception/{num}")
    public String testException(@PathVariable Integer num) {
        String s = errorService.testException(num);
        return s;
    }
}
