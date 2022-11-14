package com.aor.numbers;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class DivisibleByFilter implements GenericListFilter{
    private int diviser;
    DivisibleByFilter(int diviser){
        this.diviser = diviser;
    }
    @Override
    public boolean accept(Integer number) {

        return (number%diviser == 0);
    }
}
