package BankDemo;

import java.util.Formatter;

/*Mackenzie Redman
 * 12/8/15
 * logic assistance from TechLiterate YouTube
 * Supin Sapkota helped me transfer from scanner
 * to JFrame, and w/the file
 */

import javax.swing.JOptionPane;

public class ATM {
	
	private static Formatter x;
	
	public static void main(String[] args){
		
		
		//initialize my bank
		Bank theBank = new Bank("Bank of Mackenzie");
	      
		//add a user/account
		User aUser = theBank.addUser("Student", "Carroll", "1234");
		
		//records transaction occurrence to file
		writeFile();
		
		//add a checking account for our user
		Account newAccount = new Account("Checking", aUser, theBank);
		aUser.addAccount(newAccount);
		theBank.addAccount(newAccount);
		
		User curUser;
			
		curUser = ATM.mainMenuPrompt(theBank);

		//JFrame
		Menu things = new Menu(curUser);
	
	}
		   
	//creates a file
	public static void writeFile(){
		
		try{x = new Formatter("file.txt");} 
		catch(Exception e){System.out.println("Error");}
		
		x.format("New User Created.");
		x.close();
	}
	
	//bank and Scanner
	private static User mainMenuPrompt(Bank theBank) {
		
		//initializes 
		String userID;
		String pin;
		User authUser;
		
		//prompt user for ID/pin combo until a correct one is reached
		do{

			JOptionPane.showMessageDialog(null, "Welcome to "+ theBank.getName() +".");//\n\n %s\n\n
			userID = JOptionPane.showInputDialog("Enter User ID: ");
			//userID = sc.nextLine();
			pin = JOptionPane.showInputDialog("Enter pin: ");
			//pin = sc.nextLine();
			

			//try & get user object corresponding to both ID & pin
			authUser = theBank.userLogin(userID, pin);
			if (authUser ==null){
				JOptionPane.showMessageDialog(null, "Incorrect user ID/pin combination. " + 
						"Please try again");
			}

		}while(authUser == null);//continue looping until success

		return authUser;
	}

	
	//process deposit to an account
	static void depositFunds(User theUser) {
		
		//initializes
		int toAcct;
		double amount;
		double acctBal;
		String memo;
				
		//get account to transfer from
		do {
			toAcct = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number (1 for Checking, 2 for Savings) of the account\n" +
					"to deposit to: ", theUser.numAccounts()))-1;
			
		if (toAcct < 0 || toAcct >= theUser.numAccounts()){
			JOptionPane.showMessageDialog(null, "Invalid account, please try a gain");
			}
		}while (toAcct < 0 || toAcct >= theUser.numAccounts());
		acctBal = theUser.getAcctBalance(toAcct);
		
		//get the amount to transfer
		do{
			amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount to deposit (min $0.0):"));
			
			if (amount < 0){
				JOptionPane.showMessageDialog(null,"Amount must be greater than zero.");
			}
		}while(amount < 0);
		
		//get a memo
		memo = (JOptionPane.showInputDialog(null,"Enter a memo: "));
		
		//do the withdraw
		theUser.addAcctTransaction(toAcct, amount, memo);

	}

	//process a withdraw from account
	public static void withdrawFunds(User theUser) {
		
		//initializes
		int fromAcct;
		double amount;
		double acctBal;
		String memo;
		
		//get account to transfer from
		do {
			fromAcct = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number (1 for Checking, 2 for Savings) of the account\n" +
					"to withdraw from: ", theUser.numAccounts()))-1;
			
		if (fromAcct < 0 || fromAcct >= theUser.numAccounts()){
			JOptionPane.showInputDialog(null,"Invalid account, please try a gain");
			}
		}while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
		acctBal = theUser.getAcctBalance(fromAcct);
		
		//get the amount to transfer
		do{
			amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount to withdraw (max $" + acctBal + "):",
					acctBal));
			
			if (amount < 0){
				JOptionPane.showMessageDialog(null,"Amount must be greater than zero.");
			}else if (amount > acctBal){
				JOptionPane.showMessageDialog(null,"Amount must not be greater than\n" +
						"balance of "+ acctBal);
			}
		}while(amount < 0 || amount > acctBal);
		
		//get a memo
		memo = (JOptionPane.showInputDialog(null,"Enter a memo: "));
		
		//do the withdraw
		theUser.addAcctTransaction(fromAcct, -1 * amount, memo);
	}

	static void showTransHistory(User theUser) {
		
		int theAcct;
		
		//get account to transfer from
		do{
			theAcct = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number (1 for Checking, 2 for Savings) of the account\n" +
		" whose transactions you want to see ", theUser.numAccounts()))-1;
			if (theAcct < 0 || theAcct >= theUser.numAccounts()){
				JOptionPane.showMessageDialog(null,"Invalid account. Please try again.");
			}
			
		}while(theAcct < 0 || theAcct >= theUser.numAccounts());
		
		//print the transaction history
		theUser.printTransactionHistory(theAcct);
		
	}

	public static void transferFunds(User theUser){
		
		//initializes
		int fromAcct;
		int toAcct;
		double amount;
		double acctBal;
		
		//get account to transfer from
		do {
			fromAcct = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number (1 for Checking, 2 for Savings) of the account\n" +
					"to transfer from: ", theUser.numAccounts()))-1;
			//fromAcct = sc.nextInt()-1;
		if (fromAcct < 0 || fromAcct >= theUser.numAccounts()){
			JOptionPane.showMessageDialog(null,"Invalid account, please try a gain");
			}
		}while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
		acctBal = theUser.getAcctBalance(fromAcct);
		
		//get account to transfer to
		do {
			toAcct = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number (1 for Checking, 2 for Savings) of the account\n" +
					"to transfer to: ", theUser.numAccounts()))-1;
			//toAcct = sc.nextInt()-1;
		if (toAcct < 0 || toAcct >= theUser.numAccounts()){
			JOptionPane.showMessageDialog(null,"Invalid account, please try a gain");
			}
		}while (toAcct < 0 || toAcct >= theUser.numAccounts());
		acctBal = theUser.getAcctBalance(toAcct);
		
		//get the amount to transfer
		do{
			amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount to transfer (max $"+ acctBal +"):",
					acctBal));
			//amount = sc.nextDouble();
			if (amount < 0){
				JOptionPane.showMessageDialog(null,"Amount must be greater than zero.");
			}
		}while(amount < 0);
		
		//do transfer
		theUser.addAcctTransaction(fromAcct, -1*amount, String.format(
				"Transfer to account: ", theUser.getAcctUUID(toAcct)));
		theUser.addAcctTransaction(toAcct, amount, String.format(
				"Transfer to account: ", theUser.getAcctUUID(toAcct)));
		
	}
}