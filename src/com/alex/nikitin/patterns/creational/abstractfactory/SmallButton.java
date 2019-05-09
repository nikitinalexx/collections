package com.alex.nikitin.patterns.creational.abstractfactory;

public class SmallButton implements Button{
    @Override
    public void onClick() {
        System.out.println("Small Button Clicked");
    }
}
