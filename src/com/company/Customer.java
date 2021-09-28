package com.company;

import com.company.BankAccount;

import java.util.ArrayList;
import java.util.Optional;

public class Customer {
    private int accountId;
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(String CustomerName, int taxID){
        accountId = taxID;
        name = CustomerName;
        accounts = new ArrayList<BankAccount>();

    }
    public BankAccount openAccount(double initialDeposit){
        var newAccount = new BankAccount();
        newAccount.deposit(initialDeposit);
        var didSucceed = accounts.add(newAccount);
        return newAccount;
    }
    public Optional<BankAccount> closeAccount(int accountNumber){
        for (var account:accounts){
            if (account.getAccountId() == accountNumber){
                System.out.println("Removing account with account ID"+accountId+"from Customer: "+name);
                accounts.remove(account);
                return Optional.of(account);
            }
        }
    }
    public String getName(){
        return name;
    }
    public int getAccountId(){
        return accountId;
    }
}
