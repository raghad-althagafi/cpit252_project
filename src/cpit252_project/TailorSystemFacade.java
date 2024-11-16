package cpit252_project;

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
public class TailorSystemFacade {
    private Scanner input;
    private final CustomerService customerService;
    private final OrderService orderService;
    private   DeliveryDateSevice deliveryDateSevice;
    private   PricingSevice Pricingsevice;
    public TailorSystemFacade() {
        this.customerService = new CustomerService();
        this.orderService = new OrderService();
        this.Pricingsevice= new PricingSevice();
        this.deliveryDateSevice= new DeliveryDateSevice();
                
    }

    public TailorSystemFacade(CustomerService customerService, OrderService orderService,DeliveryDateSevice deliveryDateSevice ,PricingSevice Pricingsevice ) {
        this.customerService = customerService;
        input = new Scanner(System.in);
        this.orderService = orderService;
        this.deliveryDateSevice = deliveryDateSevice;
        this.Pricingsevice = Pricingsevice;  
    }
    
    public TailorSystemFacade(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.Pricingsevice = new PricingSevice(); // Default initialization
        this.deliveryDateSevice = new DeliveryDateSevice(); // Default initialization
    }

    public String makeOrder(){
        return (orderService.makeOrder());
    }

    public void addCustomer() {
        customerService.addCustomer();
    }
    public void calculateDeliveryDate(){
        deliveryDateSevice.calculateDeliveryDate();
    }
     public void calculatePricing(){
         Pricingsevice.calculatePricing();
     }
}
