package com.ethanzyc.allinone.interfacetest;

/**
 * @author ethan
 * @date 2019/9/12 09:30
 */

interface Car {
    String go();
}

interface CarFactory {
    Car getCar();
}

class Benz implements Car {
    @Override
    public String go() {
        System.out.println("benz go");
        return "benz go";
    }
}

class BenzFactory implements CarFactory {
    @Override
    public Benz getCar() {
        return new Benz();
    }
}

class Tesla implements Car {
    @Override
    public String go() {
        System.out.println("tesla go");
        return "tesla go";
    }
}

class TeslaFactory implements CarFactory {
    @Override
    public Tesla getCar() {
        return new Tesla();
    }
}

public class InterfaceFactory {
    public static void carConsumer(CarFactory factory) {
        Car car = factory.getCar();
        car.go();
    }

    public static void main(String[] args) {
        carConsumer(new BenzFactory());
        carConsumer(new TeslaFactory());
    }

}
