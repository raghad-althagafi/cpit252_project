/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

/**
 *
 * @author shaha
 */
public class Customer {
    
    private String phoneNumber;
    private String name;
    private int NumOfOrders;
    
     public Customer() {
        this.phoneNumber = "";
        this.name = "";
        this.NumOfOrders = 0;
    }

    public Customer(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.NumOfOrders = 0;
    }
    
    
    //check for discount if the custome is special customer
    public double checkDiscount(Customer specialCustomer ,Double price){
        double total = price;
        //if he ordered 5 orders will get discount
        if (specialCustomer.getNumOfOrders()%5==0){
            double percent= price*0.15;
            total = price-percent;
        }
        return total;
    }
    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfOrders() {
        return NumOfOrders;
    }

    public void setNumOfOrders(int NumOfOrders) {
        this.NumOfOrders = NumOfOrders;
    } 
}

