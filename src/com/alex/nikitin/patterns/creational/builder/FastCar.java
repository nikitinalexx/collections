package com.alex.nikitin.patterns.creational.builder;

public class FastCar extends Car {
    private int speed;

    public static class CarBuilder extends Car.CarBuilder<CarBuilder> {
        private int speed;

        public CarBuilder setSpeed(int speed) {
            this.speed = speed;
            return self();
        }

        @Override
        protected CarBuilder self() {
            return this;
        }

        @Override
        protected Car buildUtil() {
            FastCar fastCar = new FastCar();
            fastCar.speed = speed;
            return fastCar;
        }
    }

    public static void main(String[] args) {
        Car fastCar = new FastCar.CarBuilder().setSpeed(50).setEngine("CoolEngine").build();
    }
}
