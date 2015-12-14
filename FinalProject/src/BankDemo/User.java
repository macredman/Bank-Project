package BankDemo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	
	//variables the user will have
	private String firstName;
	private String uuid;
	private byte pinHash[];
	private ArrayList<Account> accounts;
	
	//User constructor
	public User(String firstName, String lastName, String pin, Bank theBank){
		
		//set User's name
		this.firstName = firstName;
		
		//set pin's MD5 hash
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			JOptionPane.showMessageDialog(null, "Error, caught NoSuchAlgoithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		//get new ID for user
		this.uuid = theBank.getNewUserUUID();
		
		//empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		//print log message
		JOptionPane.showMessageDialog(null, "New user " + lastName + " " + firstName + ", with ID " + this.uuid + ", created."  );
		
	}

	//add an account
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	//returns user's UUID
	public String getUUID(){
		return this.uuid;
	}

	//makes sure pin matches the right User pin
	public boolean validatePin(String aPin){
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()),
					this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			JOptionPane.showMessageDialog(null,"Error, caught NoSuchAlgoithmException");
			e.printStackTrace();
			System.exit(1);
			
			return false;
		}
	}

	//returns first name
	public String getFirstname(){
		return this.firstName;
	}

	//prints account summary
	public void printAccountsSummary() {
		
		JOptionPane.showMessageDialog(null,"\n\n%s's accounts summary\n", this.firstName, 0);
		for (int a = 0; a < this.accounts.size(); a++){
			JOptionPane.showMessageDialog(null, " %d) %s\n", this.accounts.get(a).getSummaryLine(), a+1);
		}
		
	}

	//finds # of accounts
	public int numAccounts() {
		return this.accounts.size();
	}
	
	//prints transactions for a particular account
	public void printTransactionHistory(int acctIdx){
		this.accounts.get(acctIdx).printTransactionHistory();
				
	}

	//gets balance of particular account
	public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}

	//gets account uuid
	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}

	//adds transaction
	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
}
