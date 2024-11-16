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
public class PricingSevice {
    private String garmentType;
    private String fabricType;
    private double meter;
    private boolean isUrgent;
    private double finalPrice;

    public void calculatePricing() {
        Scanner input = new Scanner(System.in);

        // Gather garment and fabric details
        System.out.println("Enter garment type (e.g., 'dress', 'blouse', 'skirt'):");
        garmentType = input.nextLine();

        System.out.println("Enter fabric type (e.g., 'cotton', 'leather', 'crepe'):");
        fabricType = input.nextLine();

        System.out.println("Enter the number of meters required:");
        meter = input.nextDouble();

        // Check if the order is urgent
        System.out.println("Is the order urgent? yes=1 / no=2");
        int isUrgentChoice = input.nextInt();
        isUrgent = (isUrgentChoice == 1);

        // Select the appropriate pricing strategy
        PricingStrategy pricingStrategy = isUrgent
                ? new UrgentPricingStrategy(new UrgentDateDecorator(null, 2)) // Decorator for urgency
                : new StandardPricingStrategy();

        // Create Price Context and calculate final price
        PriceContext priceContext = new PriceContext(pricingStrategy);
        finalPrice = priceContext.executePricingStrategy(garmentType, meter, fabricType);

        System.out.println("Final Price: " + finalPrice);
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public String getFabricType() {
        return fabricType;
    }

    public double getMeter() {
        return meter;
    }

    public boolean isUrgent() {
        return isUrgent;
    }
}