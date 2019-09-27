package com.ethanzyc.allinone.testapi;

import com.ethanzyc.allinone.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ethan
 * @date 2019/9/18 09:20
 */
@RestController
@RequestMapping("api")
public class TestApi {

    @Autowired
    HttpServletRequest request;

    @PostMapping("mixed")
    public String mixed(@RequestBody User user, @RequestParam("pa") String pa) {
        String header = request.getHeader("test-header");
        if (header == null) {
            return "error";
        } else {
            return user.toString() + "pa:" + pa;
        }
    }
}
