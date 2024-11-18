
package cpit252_project;

import java.time.LocalDate;

public class Order {

    private static int OrderID = 0;
    private double TotalPrice;
    private Customer customer;
    private double price;
    private Fabric fabric;
    private Garment garment;
    private LocalDate time;

    //constructer
    public Order() {
        ++OrderID;
    }

    public Order(Customer customer, double TotalPrice, LocalDate time) {
        ++OrderID;
        this.customer = customer;
        this.TotalPrice = TotalPrice;
        this.time = time;
    }

    //seter
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
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

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    //getter
    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return TotalPrice;
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
        return "<html>"
                + "Order ID:              " + OrderID + "<br>"
                + "Customer Name:         " + customer.getName() + "<br>"
                + "Customer Phone Number: " + customer.getPhoneNumber() + "<br>"
                + "Garment Type:          " + garment.getType() + "<br>"
                + "Fabric Type:           " + fabric.getMaterial() + "<br>"
                + "Total price:           " + TotalPrice + "<br>"
                + "Delivery Time:         " + time + "<br>"
                + "</html>";
    }
}
