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

    public TailorSystemFacade() {
        this.customerService = new CustomerService();
        this.orderService = new OrderService(customerService, input);
    }

    public TailorSystemFacade(CustomerService customerService) {
        this.customerService = customerService;
        input = new Scanner(System.in);
        this.orderService = new OrderService(customerService, input);
    }
    

    public void makeOrder(){
        orderService.makeOrder();
    }

    public void addCustomer() {
        customerService.addCustomer();
    }
}
