package kata.sg.fr.bank_account.service;


import kata.sg.fr.bank_account.data.Account;
import kata.sg.fr.bank_account.exception.NotEnoughMoneyException;
import kata.sg.fr.bank_account.repo.AccountRepository;
import kata.sg.fr.bank_account.service.impl.AccountServiceImp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;
    private AutoCloseable autoCloseable;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        accountService = new AccountServiceImp(accountRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void itShouldSuccessfullyMakeDeposit() {
        // Given
        Account account = new Account(20.0, new ArrayList<>());
        // When
        accountService.deposit(account, 50.0);
        // Then
        ArgumentCaptor<Account> argumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).addAmount(argumentCaptor.capture(), eq(50.0));
        Account capturedAccount = argumentCaptor.getValue();
        assertEquals(account, capturedAccount);
    }

    @Test
    void itShouldSuccessfullyMakeWithdrawal() throws NotEnoughMoneyException {
        // Given
        Account account = new Account(20.0, new ArrayList<>());
        // When
        accountService.withdraw(account, 10.0);
        // Then
        ArgumentCaptor<Account> argumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).retrieveAmount(argumentCaptor.capture(), eq(10.0));
        Account capturedAccount = argumentCaptor.getValue();
        assertEquals(account, capturedAccount);
    }

    @Test
    public void itShouldNotMakeAWithdrawalWithInsufficientFunds() throws NotEnoughMoneyException {
        // Given
        Account account = new Account(20.0, new ArrayList<>());
        given(accountRepository.retrieveAmount(account, 30.0)).willThrow(new NotEnoughMoneyException("Not enough money"));

        // When
        // Then
        assertThatThrownBy(() -> accountService.withdraw(account, 30.0))
                .isInstanceOf(NotEnoughMoneyException.class)
                .hasMessageContaining("Not enough money");
    }
}
