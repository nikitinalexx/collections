package com.alex.nikitin.patterns.creational.abstractfactory;

public class SmallWindow implements Window {

    @Override
    public void onResize() {
        System.out.println("Resizing small window");
    }

}
