package com.alex.nikitin.patterns.creational.abstractfactory;

public class Tester {
    private AbstractFactory componentsFactory;

    public Tester(AbstractFactory componentsFactory) {
        this.componentsFactory = componentsFactory;
    }

    public void test() {
        componentsFactory.createButton().onClick();
        componentsFactory.createWindow().onResize();
    }

    public static void main(String[] args) {
        new Tester(new BigComponentsFactory()).test();
        new Tester(new SmallComponentsFactory()).test();
    }
}
