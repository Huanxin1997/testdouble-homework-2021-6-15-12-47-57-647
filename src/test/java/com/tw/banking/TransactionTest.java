package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    @Test
    void should_return_1_when_execute_20210624_compareTo_20210624() {
        //given
        Transaction afterTransaction = new Transaction("24/6/2021", 1);
        Transaction beforeTransaction = new Transaction("24/6/2021", 1);
        //when
        int compareResult = afterTransaction.compareTo(beforeTransaction);
        //then
        assertEquals(1, compareResult);
    }

    @Test
    void should_return_1_when_execute_20210624_compareTo_20210626() {
        //given
        Transaction afterTransaction = new Transaction("24/6/2021", 1);
        Transaction beforeTransaction = new Transaction("26/6/2021", 1);
        //when
        int compareResult = beforeTransaction.compareTo(afterTransaction);
        //then
        assertEquals(1, compareResult);
    }

    @Test
    void should_return_reverse1_when_execute_20210626_compareTo_20210624() {
        //given
        Transaction afterTransaction = new Transaction("24/6/2021", 1);
        Transaction beforeTransaction = new Transaction("26/6/2021", 1);
        //when
        int compareResult = afterTransaction.compareTo(beforeTransaction);
        //then
        assertEquals(-1, compareResult);
    }
}
