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

    private final CustomerService customerService;
    private OrderBuilder orderBuilder;
    private OrderDirector orderDirector;
    private Order order;
    private Scanner input;

    public TailorSystemFacade() {
        this.customerService = new CustomerService();
        this.orderBuilder = new Invoice();
        this.orderDirector = new OrderDirector(orderBuilder);
        this.input = new Scanner(System.in);
    }

    public TailorSystemFacade(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String getGarment() {
        System.out.println("Enter garment type (e.g., 'dress', 'blouse', 'skirt'):");
        return input.nextLine();
    }

    public String getFabric() {
        System.out.println("Enter fabric type (e.g., 'cotton', 'silk', 'tulle'):");
        return input.nextLine();
    }
    
    public double getMeters(){
        System.out.println("Enter the number of meters required:");
        return input.nextDouble();
    }
    
    public boolean isUrgent(){
        int isUrgentChoice = input.nextInt();
        return (input.nextInt() == 1);
    }
    
    public int getDays(){
        System.out.println("Enter the Expected production date");
        return input.nextInt();
    }
    
    public void makeOrder(){
        Customer customer = customerService.addCustomer();
        
        String garment = getGarment();
        String fabric = getFabric();
        double meters = getMeters();
        boolean urgent = isUrgent();
        int days = getDays();
        //orderDirector.makeOrder(customer, fabricType, garmentType, deliveryDate, finalPrice);
        Order order = orderDirector.getOrder();
        System.out.println(order.GenerateInvoice());
        
    }

    public void addCustomer() {
        customerService.addCustomer();
    }

}
