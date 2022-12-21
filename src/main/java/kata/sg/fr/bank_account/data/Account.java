package kata.sg.fr.bank_account.data;


import java.util.List;
import java.util.UUID;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Operation> operations;


    public Account(double balance, List<Operation> operations) {
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = balance;
        this.operations = operations;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", operations=" + operations +
                '}';
    }
}
