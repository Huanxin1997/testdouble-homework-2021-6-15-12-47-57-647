package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class ConsoleTest {
    @Test
    void should_invoke_println_one_time_when_printLine_given_printStream() {
        // given
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String expectStr = "TEST";
        Console console = new Console();
        // when
        console.printLine(expectStr);
        // then
        verify(printStream, times(1)).println(expectStr);
    }
}