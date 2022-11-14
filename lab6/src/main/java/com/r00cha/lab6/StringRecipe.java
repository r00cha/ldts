package com.r00cha.lab6;

import java.util.List;

public class StringRecipe {
    private List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void mix(StringDrink drink){
        for(StringTransformer s : transformers){
            s.execute(drink);
        }
    }
}
