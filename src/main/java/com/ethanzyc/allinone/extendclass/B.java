package com.ethanzyc.allinone.extendclass;

import com.ethanzyc.allinone.security.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ethan
 * @date 2019/8/23 12:36
 */
public class B extends A {

    User user;

    // 父类A是有参构造,B必须也有有参构造
    B(int i) {
        super(i);
    }

    public void add() {

    }
}
