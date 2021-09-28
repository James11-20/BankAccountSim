package com.company;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCustomers = new ArrayList<Customer>();
    }
    public void doBanking(){
        var menuReader = new Scanner(System.in);
        while (true){
            printMenu();
            var userChoice = menuReader.nextInt();
            switch (userChoice){
                case 1:
                    System.exit( 0);
                case 2:
                    addCustomer(menuReader);
                    break;
                case 3:
                    Optional<Customer> current = selectCustomer(menuReader);
                    if(current.isPresent())
                        doCustomerMenu(menuReader,current.get());
                    else
                        System.out.println("Error, could not find Customer");
                    break;
                default:
                    System.out.println("Error, please choose one of the menu item");
            }
        }
    }

    private void doCustomerMenu(Scanner menuReader, Customer currentCustomer) {
        while (true){
            printCustomerMenu();
            var CustomerChoice = menuReader.nextInt();
                switch (CustomerChoice){
                    case 1:
                        openCustomerAccount(menuReader, currentCustomer);
                    case 2:
                        closeCustomerAccount(menuReader, currentCustomer);
                    case 3:
                        return;
                    case 4:
                        doYearlyMaintenance();
                        break;
                    default:
                        System.out.println("Invalid input, please choose an option");

                }
            }
        }

    private void doYearlyMaintenance() {
        for (var currentAccount: allAccounts){
            currentAccount.addIntrest();
            System.out.println("Account ID: "+currentAccount.getAccountId()+" has balance of"+currentAccount.checkBalance());
        }
    }

    private void closeCustomerAccount(Scanner menuReader, Customer currentCustomer) {
        System.out.println("What account do you want to close?: ");
        var CustomerNumber = menuReader.nextInt();
        Optional<BankAccount> accounttoClose = currentCustomer.closeAccount(currentCustomer.getAccountId());
        if(accounttoClose.isPresent()){
            allAccounts.remove(accounttoClose.get());

        }
    }

    private void openCustomerAccount(Scanner menuReader, Customer currentCustomer) {
        System.out.println("Creating Account...");
        System.out.println("How much is your initial deposit?");
        var initialDeposit = menuReader.nextDouble();
        var newAccount = currentCustomer.openAccount(initialDeposit);
        allAccounts.add(newAccount);

    }

    private void printCustomerMenu() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("What do you want to do with Customer?");
        System.out.println("    [1] Open account");
        System.out.println("    [2] Close account");
        System.out.println("    [3] Return to menu");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Enter choice");
    }

    private Optional<Customer> selectCustomer(Scanner reader) {
        System.out.println("Customer ID of Customer to select:");
        var idToFind = reader.nextInt();
        for (var currentCustomer: allCustomers){
            if (currentCustomer.getAccountId() == idToFind){
                return Optional.of(currentCustomer);
            }
        }
        return Optional.empty();
    }

    private void addCustomer(Scanner inputReader){
        inputReader.nextLine(); //eat the orphan newLine from previous nextInt call
        System.out.println("What is the newCustomer's name?");
        var customerName = inputReader.nextLine();
        System.out.println("What is new com.company.Customer's Tax ID (SSN):");
        var taxID = inputReader.nextInt();
        var newCustomer = new Customer(customerName, taxID);
        allCustomers.add(newCustomer);
    }
    private void printMenu() {
        System.out.println("*****************************************************");
        System.out.println("What would you like to do next?");
        System.out.println("    [1] Exit program");
        System.out.println("    [2] Add a Customer");
        System.out.println("    [3] Select Customer by ID");
        System.out.println("    [4] Do maintnece to show accounts");
        System.out.println("Enter choice:");
        System.out.println("*****************************************************");

    }
}
