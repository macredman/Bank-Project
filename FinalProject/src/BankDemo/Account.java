package BankDemo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Account {

	private String name;
	private String uuid;
	private ArrayList<Transaction> transactions;
	
	//Account constructor
	public Account(String name, User holder, Bank theBank){
		
		//set account name and holder
		this.name = name;
		
		//get new account UUID
		this.uuid = theBank.getNewAccountUUID();
		
		//initial transactions
		this.transactions = new ArrayList<Transaction>();
	}

	//get account ID
	public String getUUID(){
		return this.uuid;
	}

	
	//get summary
	public String getSummaryLine() {

		//get the account's balance
		double balance = this.getBalance();
		
		//format summary line according to pos/neg
		if (balance >= 0){
			return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
		}else{
			return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
		}
	}
	
	public double getBalance(){
		double balance = 0;
		for (Transaction t : this.transactions){
			balance += t.getAmount();
		}
		
		return balance;
	}
	
	//print transaction history of the account
	public void printTransactionHistory(){
		
		JOptionPane.showMessageDialog(null,"\nTransaction history for account " + this.uuid);
		for(int t = this.transactions.size()-1; t >= 0; t--){
			JOptionPane.showMessageDialog(null, this.transactions.get(t).getSummaryLine());
		}
	}

	public void addTransaction(double amount, String memo) {
		
		//create new transaction object & add to list
		Transaction newTrans =  new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
}
