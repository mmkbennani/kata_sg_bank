package kata.sg.fr.bank_account.data;

import java.time.LocalDate;

public abstract class Operation {
    private double amount;
    private LocalDate date;
    private double balance;


    

	public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Operation(double amount, LocalDate date, double balance) {
		super();
		this.amount = amount;
		this.date = date;
		this.balance = balance;
	}


    
    

}