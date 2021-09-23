package com.company;

import com.company.BankAccount;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(String CustomerName,int taxID){
        customerID = taxID;
        name = CustomerName;

    }
    public boolean openAccount(double initialDeposit){
        var newAccount = new BankAccount();
        newAccount.deposit(initialDeposit);
        var didSucceed = accounts.add(newAccount);
        return didSucceed;
    }
    public String getName(){
        return name;
    }
    public int getCustomerID(){
        return customerID;
    }
}
