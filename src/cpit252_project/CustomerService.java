package cpit252_project;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msbbr
 */
public class CustomerService {
    
    private static Scanner input = new Scanner(System.in);
    static ArrayList<Customer> Customers = new ArrayList<>(); 

    public CustomerService() {
    }
    
    //-----------------------------------------
    //method for adding Customers to system
    
    public Customer addCustomer() {
       
        System.out.print("Enter customer phone number: "); //enter phone number
        String PhoneNumber=input.next();
        
        checkPhone(PhoneNumber); //check phone
        
        //check if the customer a new one or an existed one
        Customer customer = searchCustomer(PhoneNumber);
        
        if (customer == null){ //if the customer is a new one
            System.out.print("Enter customer name: ");
            String CustomerName= input.next(); //read customer name

            customer = new Customer(PhoneNumber, CustomerName); //create customer object
        
            Customers.add(customer);//add customer to Customers arraylist
            System.out.println("The customer is successfully added");
        }
        else{ //if customer already exist
            System.out.println("The customer already added");
        }
        
        customer.setNumOfOrders(customer.getNumOfOrders()+1); //increase number of order for customer
        return customer;

    }
    
    
    //-----------------------
    //method to check phone number that satisfy the conditions
    public void checkPhone(String PhoneNumber){
        //if phone number was wrong
        while(PhoneNumber.length()!=10
                || !(PhoneNumber.matches("\\d+")) 
                || !(PhoneNumber.startsWith("05"))){
            System.out.println("incorrect phone number! It should be 10 digits and not containning any charachters. Try Again.");
            System.out.print("Enter customer phone number: ");
            PhoneNumber= input.next();
            }
        
    }
    
    
    //--------------------------------
    //method to search customer by their phone number
    public static Customer searchCustomer(String phone){
        
        Customer requiredCustomer = null;
        //search for customer
        for (int i=0; i<Customers.size(); i++){
            if(Customers.get(i).getPhoneNumber().equals(phone) && Customers.get(i)!=null){
                //if found
                requiredCustomer=Customers.get(i);
                return requiredCustomer;
            }
        }
        //if not found
        return null;
    }
    
    
}
