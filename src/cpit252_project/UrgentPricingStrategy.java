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
    @Override
    public double calculatePrice(String garmentType, double meter, String fabricType) {
        double basePrice = new StandardPricingStrategy().calculatePrice(garmentType, meter, fabricType);

        // Apply 15% additional charge for urgent orders
        return basePrice * 1.15;
    }
}