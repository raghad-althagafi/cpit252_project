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
    
    @Override
    public double calculatePrice(String garmentType, double meter, String fabricType) {
        int garmentCost = getGarmentCost(garmentType);
        int fabricCost = getFabricCost(fabricType);
        
        if (fabricCost < 0) {
            throw new IllegalArgumentException("Fabric not found.");
        }

        return garmentCost + (fabricCost * meter);
    }

    // Returns the base cost of the garment based on its type
    private int getGarmentCost(String garmentType) {
        switch (garmentType.toLowerCase()) {
            case "dress":
                return 200;
            case "blouse":
                return 50;
            case "skirt":
                return 100;
            default:
                throw new IllegalArgumentException("Invalid garment type.");
        }
    }

    // Returns the cost per meter of the fabric based on its type
    private int getFabricCost(String fabricType) {
        switch (fabricType.toLowerCase()) {
            case "crepe":
            case "satin":
            case "denim":
                return 20;
            case "polyester":
            case "linen":
            case "chiffon":
                return 15;
            case "leather":
            case "cotton":
            case "silk":
                return 30;
            case "tulle":
                return 10;
            default:
                return -1; // Return -1 if the fabric type is not found
        }
    }
}