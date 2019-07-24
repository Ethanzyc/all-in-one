package com.ethanzyc.allinone.auth.domain.response;

import com.ethanzyc.allinone.testError.exception.ResponseResult;
import com.ethanzyc.allinone.testError.exception.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class LoginResult extends ResponseResult {
    public LoginResult(ResultCode resultCode, String token) {
        super(resultCode);
        this.token = token;
    }

    private String token;
}
