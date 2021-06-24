package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class PrinterTest {

    @Test
    public void should_call_printLine_when_execute_print_given_transactions() {
        // given
        Console mockConsole = mock(Console.class);
        Printer printer = new Printer(mockConsole);
        List<Transaction> transactions = Collections.singletonList(new Transaction("2021/6/24", 1000));
        // when
        printer.print(transactions);
        // then
        verify(mockConsole, times(1)).printLine(Printer.STATEMENT_HEADER);
    }

}
