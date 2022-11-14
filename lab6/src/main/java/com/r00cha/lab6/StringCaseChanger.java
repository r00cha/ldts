package com.r00cha.lab6;

public class StringCaseChanger implements StringTransformer{

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        int size = text.length();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < size; i++) {
            char c = text.charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);

            }
            else {
                c = Character.toLowerCase(c);

            }
            s.append(c);
        }
        drink.setText(s.toString());
    }

}
