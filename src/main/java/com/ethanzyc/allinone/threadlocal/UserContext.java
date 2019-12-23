package com.ethanzyc.allinone.threadlocal;

/**
 * @author ethan
 * @date 2019/12/18 08:13
 */
public class UserContext {
    public static MyThreadLocal<User> USER_THREAD_LOCAL = new MyThreadLocal<>();

    public static User getUserThreadlocal() {
        return USER_THREAD_LOCAL.get();
    }

    public static void setUserThreadlocal(User userThreadlocal) {
        USER_THREAD_LOCAL.set(userThreadlocal);
    }
}
