// Wenting Li
// APCS1 pd08
// HW09 -- Mo Money Mo Problems
// 2017-10-04 
// Team BEC
// Larry Wong, John Liu, Wenting Li

public class BankAccount
{
    //instance variables
    private String name;
    private String passwd;
    private int pin;
    private int acctNum;
    private double balance;

	
	/* default constructor: initializes instance vars to default vals
		precondition: none
		postcondition: instance vars have appropriate default vals
	````````````````````````````````````````````````````*/
	public BankAccount() {
		name = "Team BEC";
		passwd = "Team BEC";
		pin = 1234;
		acctNum = 123456789;
		balance = 0;
	}
	
	/* overloaded constructor: allows caller to specify account number and passwd. Assigns defaults to other instance vars.
		precondition: params are passed in specified order
		postcondition: instance vars have values specified by params
	````````````````````````````````````````````````````*/
	public BankAccount(int newAcctNum, String newPass) {
		name = "Team BEC";
		passwd = newPass;
		pin = 1234;
		acctNum = newAcctNum;
		balance = 0;
	}
	
	/* overloaded constructor: allows caller to specify instance vars
		precondition:  params are passed in specified order
		postcondition: instance vars have values specified by params
		````````````````````````````````````````````````````*/
	public BankAccount(int newAcctNum, String newPass, double newBal, String newName, int newPin) {
		name = newName;
		passwd = newPass;
		pin = newPin;
		acctNum = newAcctNum;
		balance = newBal;
	}


	//mutators
	//sets the value of name to newName and returns original value of name
    public String setName(String newName)
    {
		String oldName = name;
		name = newName;
		return oldName;
    }

	//sets the value of passwd to newPasswd and returns original value of passwd
    public String setPasswd(String newPasswd)
    {
		String oldPasswd = passwd;
		passwd = newPasswd;
		return oldPasswd;
    }

	/*
	sets the value of pin to newPin if between 1000 and 9998,
	otherwise sets the value of pin to 9999 and returns message
	and always returns original value of pin
	*/
    public int setPin(int newPin)
    {
	if (newPin <= 9998 && newPin >= 1000){
	    int oldPin = pin;
	    pin = newPin;
	    return oldPin;
	} else {
	    int oldPin = pin;
	    pin = 9999;
	    System.out.print("Your new Pin was not 4 digits and not less than 9999. Your Pin is set to a default: ");
	    return oldPin;
	}
    }

	/*
	sets the value of acctNum to newAcctNum if between 100000000 and 999999998,
	otherwise sets the value of acctNum to 999999999 and returns message
	and always returns original value of newAcctNum
	*/
    public int setAcctNum(int newAcctNum)
    {
		if (newAcctNum <= 999999998 && newAcctNum >= 100000000){
	    	int oldAcctNum = acctNum;
	    	acctNum = newAcctNum;
	    	return oldAcctNum;
		} else {
	    	int oldAcctNum = acctNum;
	    	acctNum = 999999999;
	    	System.out.print("Your new Account Number was not 9 digits and not less than 999999999. Your number is set to a default: ");
	    	return oldAcctNum;
		}
    }

	//sets the value of balance to newBalance and returns the old balance
    public double setBalance(double newBalance)
    {
		double oldBalance = balance;
		balance = newBalance;
		return oldBalance;
    }

	//adds to the value of balance newBalance and prints the deposited amount and final balance
    public void deposit(double depositAmount) {
		balance = balance + depositAmount;
		System.out.println("Deposited $" 
							+ depositAmount 
			   				+ ". Current Balance: $" 
			   				+ balance);
    }

    /*
	subtracts the value of withdrawAmount from current balance if it is less than or equal to it and returns ture,
	otherwise returns false and prints and error mesage
	*/
    public boolean withdraw(double withdrawAmount) {
		if (balance >= withdrawAmount){
	    	balance = balance - withdrawAmount;
			System.out.println("Withdrew $" 
								+ withdrawAmount 
								+ ". Current Balance: $" 
								+ balance);
	    	return true;
	    
		} else {
	    	System.out.println("Insufficient Funds.");
	    	return false;
		}
    }

	/*
	checks to see if a given set of account # and passwd match
	prints "successful login" if matches and returns true,
	otherwise prints error message and returns false
	*/
    public boolean authenticate(int checkNum, String checkPasswd){
		if (checkNum == acctNum && checkPasswd == passwd) {
	    	System.out.println("Successful Login");
	    	return true;
		} else {
	    	System.out.println("Invalid Number or Password");
	    	return false;
		}
    }
    
    //overwritten toString()
    public String toString() {
		String retStr = "\nAccount info:\n=======================";
		retStr = retStr + "\nName: " + name;
		retStr = retStr + "\nPassword: " + passwd;
		retStr = retStr + "\nPIN: " + pin;
		retStr = retStr + "\nAccount Number: " + acctNum;
		retStr = retStr + "\nBalance: " + balance;
		retStr = retStr + "\n=======================";
	return retStr;
    }


    //main method for testing
    public static void main(String[] args)
    {
	// INSERT YOUR METHOD CALLS FOR TESTING HERE
    	BankAccount account = new BankAccount();
	
		account.setName("Clyde Thluffy Sinclair");
		System.out.println(account.name);
	
		account.setPasswd("superduper");
		System.out.println(account.passwd);
	
		account.setPin(5785);
		System.out.println(account.pin);

		//Invalid input

		//account.setPin(57825);
		//System.out.println(account.pin);
	
		account.setAcctNum(200000000);
        System.out.println(account.acctNum);

		//Invalid acctNum

		//account.setAcctNum(2000020000);
        //System.out.println(account.acctNum);
	
		account.setBalance(29999.99);
		System.out.println(account.balance);

		account.withdraw(2312.00);
		System.out.println(account.balance);

		//Invalid Withdraw
	
		//account.withdraw(23232312.00);
		//System.out.println(account.balance);

		account.authenticate(200000000,"superduper");

		//Invalid acctNum and passwd
	
		//account.authenticate(200200000,"1s");


    }//end main()

}//end class BankAccount