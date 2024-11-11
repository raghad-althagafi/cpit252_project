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
        this.customerService = customerService;
    }

    
    public void addCustomer(){
        customerService.addCustomer();
    }
    
}
