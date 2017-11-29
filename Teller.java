/*
Team 01 -- The Cool Kids
APCS1 pd8
HW11 -- Breaking the Bank
2017-10-04
Kevin Wang, Ying Xin Jiang, Kendrick Liang
*/

public class Teller {
    public static void main(String[] args) {
        //test cases for constructors
        BankAccount testCase1 = new BankAccount();
        BankAccount testCase2 = new BankAccount(987654321, "Howdy!");
        BankAccount testCase3 = new BankAccount(573847575, "FOO", 10000, "Bob", 3485);


        //tests for methods
        //test for toString
        //System.out.println(testCase1.toString());
        //System.out.println(testCase2.toString());
        //System.out.println(testCase3.toString());

        //test for setName
        System.out.println("Your name has been canged from " 
        + testCase1.setName("Cowboy") 
        + " to Cowboy");

        //test for setPasswd
        System.out.println("Your passwd has been changed from "
        + testCase1.setPasswd("password") 
        + " to password");

        //test for setPin
        System.out.println(testCase1.setPin(34385)); //results in error
        System.out.println("Your pin has been changed from " 
        + testCase1.setPin(5659) 
        + " to 5659");

        //test for setAcctNum
        System.out.println(testCase1.setAcctNum(0)); //results in error
        System.out.println("Your acctNum has been changed from " 
        + testCase1.setAcctNum(638509385) 
        + " to 638509385");

        //test for setBalance
        System.out.println("Your balance has been changed from " 
        + testCase1.setBalance(1) 
        + " to $3857478564");

        //test for deposit
        testCase1.deposit(1000);

        //test for withdraw
        System.out.println(testCase1.withdraw(1240394234)); //results in error
        System.out.println(testCase1.withdraw(1));

        //test for authenticate -- remember that some values of the instance vars may have changed!
        System.out.println(testCase1.authenticate(638509385, "password"));
        System.out.println(testCase1.authenticate(233963894, "6744"));
    }
}