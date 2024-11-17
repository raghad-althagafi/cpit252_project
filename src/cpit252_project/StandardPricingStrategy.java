package cpit252_project;

import cpit252_project.PricingStrategy;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author basma
 */
public class StandardPricingStrategy implements PricingStrategy {

     private AbstractFactory garmentFactory;
    private AbstractFactory fabricFactory;

    public StandardPricingStrategy() {
        this.garmentFactory = FactoryProducer.getFactory("garment");
        this.fabricFactory = FactoryProducer.getFactory("fabric");
    }

    @Override
    public double calculatePrice(String garmentType, double meter, String fabricType) {
        Garment garment = garmentFactory.getGarment(garmentType);
        Fabric fabric = fabricFactory.getFabric(fabricType);

        if (garment == null || fabric == null) {
            throw new IllegalArgumentException("Invalid garment or fabric type.");
        }

        double garmentCost = garment.getPrice();
        double fabricCost = fabric.getPrice();
        
        return garmentCost + (fabricCost * meter);
    }
}