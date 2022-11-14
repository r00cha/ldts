package com.aor.numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
public class ListFiltererTest {

    @Test
    void filter(){

        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(false);
        Mockito.when(filter.accept(3)).thenReturn(false);
        Mockito.when(filter.accept(4)).thenReturn(true);

        ListFilterer filterer = new ListFilterer(filter);
        Assertions.assertEquals(Arrays.asList(1,1,4,4), filterer.filter(Arrays.asList(1,2,1,4,3,3,4)));

    }



}
