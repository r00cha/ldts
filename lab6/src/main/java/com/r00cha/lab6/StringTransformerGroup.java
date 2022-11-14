package com.r00cha.lab6;

import java.util.List;

public class StringTransformerGroup {
    private List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void execute(StringDrink drink){
        for(StringTransformer s : transformers){
            s.execute(drink);
        }
    }
}
