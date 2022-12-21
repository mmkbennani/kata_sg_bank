package kata.sg.fr.bank_account;

import java.util.ArrayList;

import kata.sg.fr.bank_account.data.Account;
import kata.sg.fr.bank_account.exception.NotEnoughMoneyException;
import kata.sg.fr.bank_account.service.AccountService;
import kata.sg.fr.bank_account.service.impl.AccountServiceImp;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {

    	AccountService accountService = new AccountServiceImp() ;
    	
    	Account account = new Account(20.0, new ArrayList<>());
    	
    	System.out.println(account.toString());
    	
    	accountService.deposit(account, 10);
    	
    	try {
            accountService.withdraw(account, 5.0);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
        accountService.printAccountHistory(account);
        System.out.println("-----------------");
        System.out.println("-----------------");

        Account account2 = new Account(0.0, new ArrayList<>());
        
        System.out.println(account2.toString());
        try {
            accountService.withdraw(account2, 5.0);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
        accountService.deposit(account2, 10.0);
        accountService.printAccountHistory(account2);
        
        
        
    }
}
