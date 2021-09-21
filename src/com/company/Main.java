package com.company;

public class Main {

    public static void main(String[] args) {
	var myAccount = new BankAccount();
    var yourAccount = new BankAccount(intialBlance 2000, initialRate = 0.05f);
    myAccount.deposit(1000);
    var newBalance = myAccount.addIntrest();
    var yourBlance =yourAccount.addIntrest();
    var succeded = myAccount.withdraw(2000);
    if (succeded)
        System.out.println("You managed to withdraw successfully!"+myAccount.checkBalance());
    else
        System.out.println("You tried to withdraw too much, your balance is "+myAccount.checkBalance());
    }
}
