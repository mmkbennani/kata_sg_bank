package kata.sg.fr.bank_account.data;

import java.time.LocalDate;

public abstract class Operation {
    private double amount;
    private LocalDate date;
    private String type_op;




    public Operation(double amount, LocalDate date, String type_op) {
		super();
		this.amount = amount;
		this.date = date;
		this.type_op = type_op;
	}

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

	public String getType_op() {
		return type_op;
	}

	public void setType_op(String type_op) {
		this.type_op = type_op;
	}

	@Override
	public String toString() {
		return "Operation [amount=" + amount + ", date=" + date + ", type=" + type_op + "]";
	}
    
    

}