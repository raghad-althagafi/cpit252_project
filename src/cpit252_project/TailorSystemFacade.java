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

    public TailorSystemFacade(CustomerService customerService) {
        //this.login();
        this.customerService = customerService;
    }

    
    public void addCustomer(){
        customerService.addCustomer();
    }
    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your password to log in:");
        String password = input.next();
        Login login = new proxyLogin(password);
        login.login();
    }
    
}
