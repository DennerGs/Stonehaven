package com.stonehaven.model;

public class Player {
    private String name;
    private double x;
    private double y;

    public Player(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }
}