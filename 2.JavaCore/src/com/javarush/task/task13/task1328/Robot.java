package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot implements Attackable, Defensable {
    private String name;
    public Robot(String name) {
        super(name);
        this.name = name;
    }




}
