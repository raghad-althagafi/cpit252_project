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
public class Order {
    private static int OrderID =0;
    private double TotalPrice;
    private Customer customer;
//    private Pricing price;
    private Fabric fabric;
    private Garment garment;
    private CalculateDate time;

    //constructer
    public Order(){
        ++OrderID;
    }
    public Order(double TotalPrice, Customer customer,  CalculateDate time) {
        ++OrderID;
        this.TotalPrice = TotalPrice;
        this.customer = customer;
//        this.price = price;
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

    public void setTime(CalculateDate time) {
        this.time = time;
    }

    //getter
    public double getTotalPrice() {
        return TotalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CalculateDate getTime() {
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
        return "============ INVOICE ============" + "\n" +
                "Order ID:              " + OrderID + "\n" +
                "Customer Name:         " + customer.getName() + "\n" +
                "Customer Phone Number: " + customer.getPhoneNumber() + "\n" +
                "Garment Type:          " + garment.getType() + "\n" +
                "Fabric Type:           " + fabric.getMaterial() + "\n" +
//                "Total price:           " + customer.checkDiscount(customer, price.getPrice()) + "\n" +
                "Delivery Time:           "+
                "===============================";
    }
}
