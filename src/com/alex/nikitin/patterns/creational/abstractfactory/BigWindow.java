package com.alex.nikitin.patterns.creational.abstractfactory;

public class BigWindow implements Window {
    @Override
    public void onResize() {
        System.out.println("Big Window");
    }
}
