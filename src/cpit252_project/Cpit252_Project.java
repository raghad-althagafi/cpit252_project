/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.time.LocalDate;
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
        Login L = new proxyLogin("raghad", "raghad");
        TailorSystemFacade TailorSystemFacade = L.login();
        
        //TailorSystemFacade.addCustomer(); //add customer service
        //TailorSystemFacade.login();
        
        
        //-------------------------
        
       
        
        
        //----------------------------------Strategy pattern and Decorator pattern for price and date -----------------------
//   
//        Scanner input = new Scanner(System.in);
//
//          // Get user input
//        System.out.println("Enter garment type (e.g., 'dress', 'blouse', 'skirt'):");
//        String garmentType = input.nextLine();
//
//        System.out.println("Enter fabric type (e.g., 'cotton', 'silk', 'tulle'):");
//        String fabricType = input.nextLine();
//
//        System.out.println("Enter the number of meters required:");
//        double meter = input.nextDouble();
//
//        System.out.println("Is the order urgent? yes=1 / no=2");
//        int isUrgentChoice = input.nextInt();
//        boolean isUrgent = (isUrgentChoice == 1);
//
//        // Standard Pricing Strategy
//        PricingStrategy pricingStrategy = new StandardPricingStrategy();
//
//        // Calculate delivery date
//        DeliveryDate deliveryDateCalculator = new CalculateDate();
//        if (isUrgent) {
//            // Apply the Rush Date Decorator for urgent orders
//            RushDateDecorator rushDecorator = new RushDateDecorator(deliveryDateCalculator, 2); // e.g., 2 days rush
//            deliveryDateCalculator = rushDecorator;  // Use the decorated calculator
//            pricingStrategy = new UrgentPricingStrategy(rushDecorator); // Apply Urgent Pricing Strategy
//        }
//
//        // Create Price Context and calculate the price
//        PriceContext priceContext = new PriceContext(pricingStrategy);
//        double finalPrice = priceContext.executePricingStrategy(garmentType, meter, fabricType);
//
//        // Calculate delivery date
//        LocalDate deliveryDate = deliveryDateCalculator.calculateDeliveryDate(7); // Assume 7 days for standard delivery
//        System.out.println("The final price is: " + finalPrice);
//        System.out.println("The estimated delivery date is: " + deliveryDate);
     
        //--------------------------------------------------------------
        //database db = new database();
        //System.out.println(db.checkLogin("raghad", "raghad"));
    }
    
}
