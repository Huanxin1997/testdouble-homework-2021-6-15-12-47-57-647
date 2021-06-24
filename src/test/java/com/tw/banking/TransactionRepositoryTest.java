package com.tw.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TransactionRepositoryTest {
    @Mock
    Clock clock;

    private TransactionRepository transactionRepository;

    @BeforeEach
    public void init() {
        clock = mock(Clock.class);
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    void should_return_size_1_list_when_execute_allTransactions_given_addDeposit() {
        //given
        int expectAmount = 1000;
        transactionRepository.addDeposit(expectAmount);
        //when
        List<Transaction> transactions = transactionRepository.allTransactions();
        //then
        assertEquals(1, transactions.size());
    }

    @Test
    void should_add_same_amount_as_expectAmount_when_addDeposit() {
        //given
        int expectAmount = 1000;
        //when
        transactionRepository.addDeposit(expectAmount);
        //then
        assertEquals(expectAmount, transactionRepository.transactions.get(0).amount());
    }

    @Test
    void should_add_negative_amount_as_expectAmount_when_addWithdraw() {
        //given
        int expectAmount = 1000;
        //when
        transactionRepository.addWithdraw(expectAmount);
        //then
        assertEquals(-expectAmount, transactionRepository.transactions.get(0).amount());
    }
}