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
public class FabricFactory extends AbstractFactory{

    public FabricFactory() {
    }
    
    @Override
    public Fabric getFabric(String fabric){
        if(fabric==null){
            return null;
        }
        if(fabric.equalsIgnoreCase("COTTON")){
            return new Cotton();
        }
        else if(fabric.equalsIgnoreCase("CREPE")){
            return new Crepe();
        }
        else if(fabric.equalsIgnoreCase("LEATHER")){
            return new Leather();
        }
        return null;
    }
    
    @Override
    public Garment getGarment(String garment){
        return null;
    }
}
