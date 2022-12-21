package kata.sg.fr.bank_account.data;

import java.time.LocalDate;

public class Withdrawal extends Operation {
    public Withdrawal(double amount, double balance) {
        super(amount, LocalDate.now(),balance);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "-" + this.getAmount() +
                ", date=" + this.getDate() +
                ", balance=" + this.getBalance() +
                '}';
    }
}
