package com.alex.nikitin.patterns.creational.abstractfactory;

public class SmallComponentsFactory implements AbstractFactory{
    @Override
    public Button createButton() {
        return new SmallButton();
    }

    @Override
    public Window createWindow() {
        return new SmallWindow();
    }
}
