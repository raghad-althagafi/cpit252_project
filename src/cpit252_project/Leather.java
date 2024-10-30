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
public class Leather implements Fabric{
    private double price=30;

    public Leather() {
    }
    
    @Override
    public double getPrice(){
        return this.price;
    }
    
    @Override
    public String getMaterial(){
        return "Leather";
    }
}
