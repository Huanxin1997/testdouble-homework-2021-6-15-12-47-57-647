package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {

    private TransactionRepository getTransactionRepository() {
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        return spy(transactionRepository);
    }

    private Printer getPrinter() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        return spy(printer);
    }

    @Test
    public void should_call_addDeposit_when_execute_deposit_given_amount(){
        // given
        TransactionRepository spyTransactionRepository = getTransactionRepository();
        Printer spyPrinter = getPrinter();

        // when
        Account account = new Account(spyTransactionRepository, spyPrinter);
        account.deposit(100);

        // then
        verify(spyTransactionRepository, times(1)).addDeposit(anyInt());
    }

    @Test
    public void should_call_addWithdraw_when_execute_deposit_given_amount(){
        // given
        TransactionRepository spyTransactionRepository = getTransactionRepository();
        Printer spyPrinter = getPrinter();

        // when
        Account account = new Account(spyTransactionRepository, spyPrinter);
        account.withdraw(100);

        // then
        verify(spyTransactionRepository, times(1)).addWithdraw(anyInt());
    }

    @Test
    public void should_call_print_when_execute_printStatement_given_amount(){
        // given
        TransactionRepository mockTransactionRepository = mock(TransactionRepository.class);
        Printer spyPrinter = getPrinter();

        // when
        List<Transaction> transactionList = new ArrayList<>();
        doReturn(transactionList).when(mockTransactionRepository).allTransactions();
        Account account = new Account(mockTransactionRepository, spyPrinter);
        account.printStatement();

        // then
        verify(spyPrinter, times(1)).print(transactionList);
    }

}
