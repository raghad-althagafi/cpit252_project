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
public class AbstractFactoryDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractFactory fabricFactory = FactoryProducer.getFactory("Fabric");
        
        Fabric fabric1 = fabricFactory.getFabric("COTTON");
        System.out.println(fabric1.getPrice()+" "+fabric1.getMaterial());
        
        AbstractFactory garmentFactory = FactoryProducer.getFactory("garment");
        
        Garment garment1 = garmentFactory.getGarment("DRESS");
        System.out.println(garment1.getPrice()+" "+garment1.getType());
    }
    
}
