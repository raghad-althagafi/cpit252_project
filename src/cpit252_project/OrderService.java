package cpit252_project;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shaha
 */
public class OrderService {
    private static Scanner input;
    static ArrayList<Order> Orders = new ArrayList<>();
    private CustomerService customerService;
    private OrderBuilder orderBuilder;
    private OrderDirector orderDirector;
    private Order order;
private PricingSevice Pricingsevice;
    private DeliveryDateSevice deliveryDateSevice;
    
    public OrderService(){
        this.customerService = new CustomerService();
        this.orderBuilder = new Invoice();
        this.orderDirector = new OrderDirector(orderBuilder);
        this.input = new Scanner(System.in);
this.Pricingsevice = new PricingSevice();
        this.deliveryDateSevice = new DeliveryDateSevice();    }

//    public String getGarment() {
//        System.out.println("Enter garment type (e.g., 'dress', 'blouse', 'skirt'):");
//        return input.nextLine();
//    }
//
//    public String getFabric() {
//        System.out.println("Enter fabric type (e.g., 'cotton', 'leather', 'crepe'):");
//        String garment = input.nextLine();
//        return garment;
//    }
//    
//    public double getMeters(){
//        System.out.println("Enter the number of meters required:");
//        return input.nextDouble();
//    }
//    
//    public boolean isUrgent(){
//        int isUrgentChoice = input.nextInt();
//        return (input.nextInt() == 1);
//    }
//    
//    public int getDays(){
//        System.out.println("Enter the Expected production date");
//        return input.nextInt();
//    }
    
    public String makeOrder(){
        Customer customer = customerService.addCustomer();
        Pricingsevice.calculatePricing();
        String garment = Pricingsevice.getGarmentType();
        String fabric = Pricingsevice.getFabricType();
        //double meters = ;
//        boolean urgent = priceAndDeliery.isUrgent();
        deliveryDateSevice.calculateDeliveryDate();
        LocalDate deliveryDate = deliveryDateSevice.getDeliveryDate();
        double finalPrice = Pricingsevice.getFinalPrice();
        orderDirector.makeOrder(customer, fabric, garment, deliveryDate, finalPrice);
        Order order = orderDirector.getOrder();
        Orders.add(order);
        return (order.GenerateInvoice()); 
    }
}
