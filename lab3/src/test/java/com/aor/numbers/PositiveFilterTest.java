package com.aor.numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
public class PositiveFilterTest {

    @Test
    void filter(){
        PositiveFilter filter = new PositiveFilter();
        List<Integer> positives = Arrays.asList(1,2,3,4,5);
        List<Integer> negatives = Arrays.asList(0,-1,-2,-3,-4);

        for (int i : positives){
            Assertions.assertTrue(filter.accept(i));
        }

        for (int i : negatives){
            Assertions.assertFalse(filter.accept(i));
        }

    }

}
