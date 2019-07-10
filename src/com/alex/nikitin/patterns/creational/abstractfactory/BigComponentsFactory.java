package com.alex.nikitin.patterns.creational.abstractfactory;

public class BigComponentsFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new BigButton();
    }

    @Override
    public Window createWindow() {
        return new BigWindow();
    }
}
