package com.ethanzyc.allinone.thread.ch3.consumer.six;

/**
 * @author ethan
 * @date 2019/10/6 21:16
 */
public class P {
    private MyStack myStack;

    public P(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}
