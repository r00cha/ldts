package com.r00cha.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Bar {
    public Bar(){
        this.observers = Arrays.asList();
    };
    private List<BarObserver> observers;
    abstract public boolean isHappyHour();
    abstract public void startHappyHour();
    abstract public void endHappyHour();
    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
