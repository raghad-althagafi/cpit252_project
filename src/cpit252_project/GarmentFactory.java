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
public class GarmentFactory extends AbstractFactory{

    public GarmentFactory() {
    }
    
    @Override
    public Garment getGarment(String garment){
        if(garment==null){
            return null;
        }
        if(garment.equalsIgnoreCase("DRESS")){
            return new Dress();
        }
        else if(garment.equalsIgnoreCase("BLOUSE")){
            return new Blouse();
        }
        else if(garment.equalsIgnoreCase("SKIRT")){
            return new Skirt();
        }
        return null;
    }
    
    @Override
    public Fabric getFabric(String fabric){
        return null;
    }
}

