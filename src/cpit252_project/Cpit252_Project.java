/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.util.Scanner;

/**
 *
 * @author AHC
 */
public class Cpit252_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //-------------------------
        //Facade
        
        CustomerService customerService = new CustomerService(); 
        
        TailorSystemFacade TailorSystemFacade = new TailorSystemFacade(customerService);
        TailorSystemFacade.addCustomer(); //add customer service
        
        //-------------------------
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your password to log in:");
        String password = input.next();
        Login login = new proxyLogin(password);
        login.login();
        
    }
    
}
