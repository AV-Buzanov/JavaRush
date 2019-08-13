package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public int passangers;
    @Override
    public void fly() {

    }
    public Plane (int pass) {
        this.passangers=pass;
    }
}
