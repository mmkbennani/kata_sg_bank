package kata.sg.fr.bank_account.data;

import java.time.LocalDate;

public class Withdrawal extends Operation {
    public Withdrawal(double amount) {
        super(amount, LocalDate.now(),"W");
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "-" + this.getAmount() +
                ", date=" + this.getDate() +
                '}';
    }
}
