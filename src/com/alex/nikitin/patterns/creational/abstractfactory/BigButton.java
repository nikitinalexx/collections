package com.alex.nikitin.patterns.creational.abstractfactory;

public class BigButton implements Button{


    @Override
    public void onClick() {
        System.out.println("Big Button Clicked");
    }
}
