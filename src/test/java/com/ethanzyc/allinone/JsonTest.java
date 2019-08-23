package com.ethanzyc.allinone;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ethanzyc.allinone.jpa.User;
import com.github.pagehelper.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ethan
 * @date 2019/7/25 12:47
 */
public class JsonTest {

    @Test
    public void testJson() {
        List<User> users = new ArrayList<>();

        Page<User> page = new Page<>();

        for (int i = 0; i < 5; i++) {
            User u = User.builder().id(i).email("i" + i).name(Math.random() + "").build();
            users.add(u);
        }

        String s = JSON.toJSONString(users);
        System.out.println(s);

        List<User> list = JSON.parseObject(s, new TypeReference<List<User>>() {
        });
        System.out.println(list);
    }

    @Test
    public void testParse() {
        String s = "[{\"message\":\"RE1908190000006提交成功！！\",\"id\":\"112\",\"code\":0,\"objectid\":10381}]";
        JSONArray objects = JSON.parseArray(s);
        Map<String, Object> map = (Map<String, Object>) objects.get(0);
        Integer code = (Integer) map.get("code");
        System.out.println(code);

    }
}
