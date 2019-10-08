package com.ethanzyc.allinone.thread.ch3.consumer.four;

/**
 * @author ethan
 * @date 2019/10/7 09:31
 */
public class C {
    private MyStack myStack;

    public C(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }
}
