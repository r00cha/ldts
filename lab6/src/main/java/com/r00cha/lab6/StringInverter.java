package com.r00cha.lab6;

public class StringInverter implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        StringBuilder s = new StringBuilder(text);
        s.reverse();
        drink.setText(s.toString());
    }
}
