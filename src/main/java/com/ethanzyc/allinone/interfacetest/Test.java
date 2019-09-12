package com.ethanzyc.allinone.interfacetest;

import static java.lang.System.*;

/**
 * @author ethan
 * @date 2019/9/12 08:24
 */
public class Test {
    public static void main(String[] args) {
        Instrument instrument = new Instrument() {
            @Override
            public void stop() {

            }

            @Override
            public Object start() {
                return null;
            }

        };
        instrument.play();

        Instrument wind = new Wind();
        String start = (String) wind.start();
        out.println(start);
        wind.play();

        wind.play();
        wind.start();
        wind.stop();
        ((Wind) wind).stop2();

        int a = Instrument.A;
        out.println("a:" + a);
        a = 5;
        out.println("a after:" + a);
        out.println("a after:" + a);
    }
}
