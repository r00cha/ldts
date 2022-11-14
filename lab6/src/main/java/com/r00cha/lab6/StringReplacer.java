package com.r00cha.lab6;

public class StringReplacer implements StringTransformer{
    private char c1;
    private char c2;

    public StringReplacer(char c1, char c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(c1,c2);
        drink.setText(text);
    }
}
