package com.ethanzyc.allinone.testError.service;

import com.ethanzyc.allinone.testError.exception.CommonCode;
import com.ethanzyc.allinone.testError.exception.CustomException;
import com.ethanzyc.allinone.testError.exception.ResultCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ethan
 * @date 2019/6/24 23:14
 */
@Service
public class ErrorService {

    public String testException(Integer num) {
        if (num == 1) {
            throw new CustomException(CommonCode.FAIL);
        } else if (num == 2) {
            List a = null;
            a.size();
            return "null exception";
        } else {
            return "success";
        }
    }
}
