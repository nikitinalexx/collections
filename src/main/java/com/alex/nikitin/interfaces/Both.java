package com.alex.nikitin.interfaces;

public class Both extends D implements A, B, C {

    @Override
    public void a() {

    }

    public static void main(String[] args) {
        Both both = new Both();
        both.s();
    }


}
