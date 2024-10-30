/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

/**
 *
 * @author Dana2
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Garment"))
            return new GarmentFactory();
        else if(choice.equalsIgnoreCase("Fabric"))
            return new FabricFactory();
        
        return null;
    }
}
