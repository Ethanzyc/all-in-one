package com.ethanzyc.allinone.clone;

/**
 * @author ethan
 * @date 2019/8/30 23:53
 */
public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Data data = new Data();
        data.setValue(1);

        Data clone = data.clone();

        System.out.println("data==clone:" + (data == clone));
        System.out.println("data.value==clone.value:" + (data.getValue() == clone.getValue()));

    }
}

class Data extends Object implements Cloneable {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Data clone() throws CloneNotSupportedException {
        Data data = (Data) super.clone();
        return data;
    }
}
