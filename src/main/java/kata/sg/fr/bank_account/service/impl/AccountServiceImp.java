package kata.sg.fr.bank_account.service.impl;

import kata.sg.fr.bank_account.data.Account;
import kata.sg.fr.bank_account.data.Deposit;
import kata.sg.fr.bank_account.data.Withdrawal;
import kata.sg.fr.bank_account.exception.NotEnoughMoneyException;
import kata.sg.fr.bank_account.repo.AccountRepository;
import kata.sg.fr.bank_account.service.AccountService;

public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository= new AccountRepository();

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(Account account, double amount) {
        accountRepository.addAmount(account, amount);
        accountRepository.addOperation(account, new Deposit(amount, account.getBalance()));
    }

    @Override
    public void withdraw(Account account, double amount) throws NotEnoughMoneyException {
        accountRepository.retrieveAmount(account, amount);
        accountRepository.addOperation(account, new Withdrawal(amount,  account.getBalance()));
    }

    @Override
    public void printAccountHistory(Account account) {
        System.out.println(accountRepository.getAccountHistory(account));
    }
}
