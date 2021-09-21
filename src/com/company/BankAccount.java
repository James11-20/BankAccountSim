package com.company;

public class BankAccount {
    private double balance;
    private float interestRate;
    private int acountId;
    private static int nextId = 100;

    public BankAccount(){
        interestRate = 0.02f;
        acountId = nextId;
        nextId++;
    }
    public BankAccount(float intitalBlance,float interestRate) {
        balance = intitalBlance;
        interestRate = intitalBlance;
        acountId = nextId;
        nextId =+1;
    }
    public int getAccountId(){
        return acountId;
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
