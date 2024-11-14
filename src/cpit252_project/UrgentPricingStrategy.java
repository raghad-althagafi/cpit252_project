/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpit252_project;

import cpit252_project.PricingStrategy;

/**
 *
 * @author basma
 */
public class UrgentPricingStrategy implements PricingStrategy {
private final UrgentDateDecorator deliveryDecorator;

    public UrgentPricingStrategy(UrgentDateDecorator deliveryDecorator) {
        this.deliveryDecorator = deliveryDecorator;
    }
    @Override
    public double calculatePrice(String garmentType, double meter, String fabricType) {
        double basePrice = new StandardPricingStrategy().calculatePrice(garmentType, meter, fabricType);
       
        if (deliveryDecorator.isUrgent()) {
            return basePrice * 1.15; // 15% additional charge for urgent orders
        }
         return basePrice;

    }
}