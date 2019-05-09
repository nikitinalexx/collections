package com.alex.nikitin.patterns.creational.builder;

public class Car {
    private int seats;
    private String engine;
    private boolean tripComputer;
    private int gps;

    public static abstract class CarBuilder<T extends CarBuilder<T>> {
        private int seats;
        private String engine;
        private boolean tripComputer;
        private int gps;


        public T setSeats(int seats) {
            this.seats = seats;
            return self();
        }

        public T setEngine(String engine) {
            this.engine = engine;
            return self();
        }

        public T setTripComputer() {
            this.tripComputer = true;
            return self();
        }

        public T setGps(int gps) {
            this.gps = gps;
            return self();
        }

        protected abstract T self();

        public Car build() {
            Car car = buildUtil();
            car.seats = seats;
            car.engine = engine;
            car.tripComputer = tripComputer;
            car.gps = gps;
            return car;
        }

        protected abstract Car buildUtil();

    }
}
