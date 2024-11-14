/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpit252_project;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author basma
 */
public class PricingAndDeliveryDateService {
   private boolean isUrgent;
   private double finalPrice;
   private LocalDate deliveryDate;
   private String garmentType;
   private String fabricType;

   public void calculatePricingAndDeliveryDate() {
       Scanner input = new Scanner(System.in);  

       // Gather garment and fabric details
       System.out.println("Enter garment type (e.g., 'dress', 'blouse', 'skirt'):");
       garmentType = input.nextLine();

       System.out.println("Enter fabric type (e.g., 'cotton', 'leather', 'crepe'):");
       fabricType = input.nextLine();

       System.out.println("Enter the number of meters required:");
       double meter = input.nextDouble();

       // Check if the order is urgent
       System.out.println("Is the order urgent? yes=1 / no=2");
       int isUrgentChoice = input.nextInt();
       isUrgent = (isUrgentChoice == 1);

       PricingStrategy pricingStrategy = new StandardPricingStrategy();
       DeliveryDate deliveryDateCalculator = new CalculateDate();

       if (isUrgent) {
           UrgentDateDecorator rushDecorator = new UrgentDateDecorator(deliveryDateCalculator, 2); // e.g., 2-day rush
           deliveryDateCalculator = rushDecorator;
           pricingStrategy = new UrgentPricingStrategy(rushDecorator); // Apply Urgent Pricing Strategy
       }

       // Create Price Context and calculate final price
       PriceContext priceContext = new PriceContext(pricingStrategy);
       finalPrice = priceContext.executePricingStrategy(garmentType, meter, fabricType);

       // Get expected date from the user and calculate delivery date
       System.out.println("Enter the Expected production date (in days):");
       int expectedProductionDays = input.nextInt();
       deliveryDate = deliveryDateCalculator.calculateDeliveryDate(expectedProductionDays);

   }

   public double getFinalPrice() {
       return finalPrice;
   }

   public LocalDate getDeliveryDate() {
       return deliveryDate;
   }

   public boolean isUrgent() {
       return isUrgent;
   }

   public String getGarmentType() {
       return garmentType;
   }

   public String getFabricType() {
       return fabricType;
   }
}