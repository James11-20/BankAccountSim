package com.company;
import java.util.ArrayList;
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
                    Customer current = selectCustomer(menuReader);
                    break;
                default:
                    System.out.println("Error, please choose one of the menu item");
            }
        }
    }
    private Customer selectCustomer(Scanner reader) {
        System.out.println("Customer ID of Customer to select:");
        var idtoFind = reader.nextLine();
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
        System.out.println("What would you like to do next?");
        System.out.println("    [1] Exit program");
        System.out.println("    [2] Add a Customer");
        System.out.println("    [3] Select Customer by ID");
        System.out.println("Enter choice:");

    }
}
