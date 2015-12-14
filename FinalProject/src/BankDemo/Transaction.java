package BankDemo;

import java.util.Date;

public class Transaction {
	
	//initializes
	private double amount;
	private Date timestamp;
	private String memo;
	private Account inAccount;
	
	//create new transaction
	public Transaction(double amount2, Account inAccount){
		
		this.amount = amount2;
		this.inAccount = inAccount;
		this.timestamp = new Date();
		this.memo = "";
	}
	
	//create new transaction and the memo
	public Transaction(double amount2, String memo, Account inAccount){
		
		//call 2-arg constructor first
		this(amount2, inAccount);
		
		//set memo
		this.memo = memo;
	}

	//get amount of transaction
		public double getAmount() {
			return this.amount;
	}
	
	//get a summary string
	public String getSummaryLine(){
		if(this.amount >= 0){
			return String.format("%s : $%.02f : %s", this.timestamp.toString(),
					this.amount, this.memo);
		}else{
			return String.format("%s : $(%.02f) : %s", 
					this.timestamp.toString(), this.amount, this.memo);
		}
	
	}
}
