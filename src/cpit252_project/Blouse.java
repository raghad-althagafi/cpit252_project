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
public class Blouse implements Garment{
    private double price=50;

    public Blouse() {
    }
    
    @Override
    public double getPrice(){
        return this.price;
    }
    
    @Override
    public String getType(){
        return "Blouse";
    }
}
