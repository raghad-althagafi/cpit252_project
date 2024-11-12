/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.time.LocalDate;

/**
 *
 * @author shaha
 */
public class Order {
    private static int OrderID =0;
    private double TotalPrice;
    private Customer customer;
    private double price;
    private Fabric fabric;
    private Garment garment;
    private LocalDate time;

    //constructer
    public Order(){
        ++OrderID;
    }
    public Order(double TotalPrice, Customer customer,  LocalDate time) {
        ++OrderID;
        this.TotalPrice = TotalPrice;
        this.customer = customer;
        this.time = time;
    }

    //seter

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }
    public void setGarment(Garment garment) {
        this.garment = garment;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    //getter
    public double getTotalPrice() {
        return TotalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getTime() {
        return time;
    }

    public int getOrderID() {
        return OrderID;
    }

    public Fabric getFabric() {
        return fabric;
    }
    public Garment getGarment() {
        return garment;
    }

    //to print invoice method
    public String GenerateInvoice() {
        return "<html>"+
                "Order ID:              " + OrderID + "<br>" +
                "Customer Name:         " + customer.getName() + "<br>" +
                "Customer Phone Number: " + customer.getPhoneNumber() + "<br>" +
                "Garment Type:          " + garment.getType() + "<br>" +
                "Fabric Type:           " + fabric.getMaterial() + "<br>" +
//                "Total price:           " + customer.checkDiscount(customer, TotalPrice) + "\n" +
                "Total price:           " + TotalPrice + "<br>" +

                "Delivery Time:         " +  time + "<br>" +
                "</html>";
    }
}
