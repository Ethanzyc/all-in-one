package com.ethanzyc.allinone.interfacetest;

import static java.lang.System.*;

/**
 * @author ethan
 * @date 2019/9/12 08:24
 */
public class Wind implements Instrument, Instrument2 {
    @Override
    public void play() {
        out.println("wind play");
    }

    @Override
    public void stop2() {

    }

    @Override
    public void stop() {
        out.println("wind stop");
    }

    @Override
    public String start() {
        return "wind string start";
    }
}
