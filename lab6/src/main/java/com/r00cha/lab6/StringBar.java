package com.r00cha.lab6;

import java.util.List;

public class StringBar extends Bar{
    private boolean happy = false;

    @Override
    public boolean isHappyHour() {
        return happy;
    }

    @Override
    public void startHappyHour() {
        this.happy = true;
    }

    @Override
    public void endHappyHour() {
        this.happy = false;
    }
}
