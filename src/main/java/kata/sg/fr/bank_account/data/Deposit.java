package kata.sg.fr.bank_account.data;

import java.time.LocalDate;


public class Deposit extends Operation {

    public Deposit(double amount) {
        super(amount, LocalDate.now(),"D");
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "+" + this.getAmount() +
                ", date=" + this.getDate() +
                "}";
    }
}