package com.company;

public class BankAccount {
    private double balance;
    private float interestRate;
    private int accountId;
    private static int nextId = 100;

    public BankAccount(){
        interestRate = 0.02f;
        accountId = nextId;
        nextId++;
    }
    public BankAccount(float initialBlance,float interestRate) {
        balance = initialBlance;
        interestRate = initialBlance;
        accountId = nextId;
        nextId =+1;
    }
    public int getAccountId(){
        return accountId;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(amount>balance){
            return false;
        }
        else balance = balance - amount;
        return true;
    }
    public double addIntrest(){
        interestRate = (float) (interestRate);
        balance+= interestRate*balance;
                return balance;
    }
    public double checkBalance(){
        return balance;
    }


}
