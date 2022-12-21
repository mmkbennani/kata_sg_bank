package kata.sg.fr.bank_account.data;

import java.time.LocalDate;


public class Deposit extends Operation {

    public Deposit(double amount, double balance) {
        super(amount, LocalDate.now(),balance);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "+" + this.getAmount() +
                ", date=" + this.getDate() +
                ", balance=" + this.getBalance() +
                "}";
    }
}