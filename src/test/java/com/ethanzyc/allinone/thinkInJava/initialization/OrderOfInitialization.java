package com.ethanzyc.allinone.thinkInJava.initialization;

/**
 * @author ethan
 * @date 2019/8/5 08:16
 */
class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class Window1 {
    Window1(int marker) {
        System.out.println("Window1(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1);
    Window1 w11 = new Window1(1);

    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);
    Window1 w12 = new Window1(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
    Window1 w13 = new Window1(3);
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}




