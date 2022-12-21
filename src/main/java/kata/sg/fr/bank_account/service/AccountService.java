package kata.sg.fr.bank_account.service;

import kata.sg.fr.bank_account.data.Account;
import kata.sg.fr.bank_account.exception.NotEnoughMoneyException;

public interface AccountService {

    void deposit(Account account, double amount);

    void withdraw(Account account, double amount) throws NotEnoughMoneyException;

    void printAccountHistory(Account account);
}
