package com.pluralsight.models;

public interface Driveable {
    void accelerate(int pressure);
    void brake(int pressure);
    int steer(char direction); // 'L' or 'R'
    int getSpeed();
}
