package com.aor.numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    void acceptdividedby5() {

        DivisibleByFilter filter = new DivisibleByFilter(5);
        List<Integer> divisible = Arrays.asList(0, 5, 10, 15);
        List<Integer> notDivisible = Arrays.asList(1, 2, 3, 4, 7612);


        ListFilterer filterer = new ListFilterer(filter);
        Assertions.assertEquals(Arrays.asList(0, 5, 10, 15),filterer.filter(divisible));
        Assertions.assertEquals(Arrays.asList(), filterer.filter(notDivisible));
    }

}

