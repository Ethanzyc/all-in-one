package com.ethanzyc.allinone.auth.domain.ext;

import com.ethanzyc.allinone.auth.domain.XcMenu;
import com.ethanzyc.allinone.auth.domain.XcUser;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcUserExt extends XcUser {

    //权限信息
    private List<XcMenu> permissions;

    //企业信息
    private String companyId;
}