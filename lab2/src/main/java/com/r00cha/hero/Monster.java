package com.r00cha.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    Monster(int x, int y){
        super(x,y);
    }
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffcc66"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        //graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");

    }

    public Position move(){
        switch (new Random().nextInt(4)) {
            case 0:
                return new Position(position.getX(), position.getY() - 1);

            case 1:
                return new Position(position.getX() + 1, position.getY());

            case 2:
                return new Position(position.getX(), position.getY() + 1);

            case 3:
                return new Position(position.getX() - 1, position.getY());
        }
        return new Position(position.getX(), position.getY());
    }
}