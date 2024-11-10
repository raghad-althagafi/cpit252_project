/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpit252_project;

/**
 *
 * @author basma
 */
public class PriceContext {
    private PricingStrategy strategy;

    public PriceContext(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double executePricingStrategy(String garmentType, double meter, String fabricType) {
        return strategy.calculatePrice(garmentType, meter, fabricType);
    }
}