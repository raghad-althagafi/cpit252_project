/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

/**
 *
 * @author shaha
 */
import java.time.LocalDate;
import static java.time.LocalDate.now;
public class Delivery_Date {
    
    private LocalDate orderDate;
    private int expectedProduction_days;
    private LocalDate delivery_date;

    //constructer
    public Delivery_Date(LocalDate orderDate,int expectedProduction_days,LocalDate delivery_date){
        this.orderDate= now();
        this.expectedProduction_days= expectedProduction_days;
        this.delivery_date = delivery_date;
    }
    
    public Delivery_Date(LocalDate orderDate,int expectedProduction_days){
        this.expectedProduction_days = expectedProduction_days;
        
        
    }
    
    //getter and setter
    
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getExpectedProduction_days() {
        return expectedProduction_days;
    }

    public void setExpectedProduction_days(int expectedProduction_days) {
        this.expectedProduction_days = expectedProduction_days;
    }

    public LocalDate getDelivery_date() {
        
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }
    
    // functhion to calculate the delivery date
    public LocalDate CalculateDeliveryDate(LocalDate orderDate,int expectedProduction_days){ 
        
        delivery_date = orderDate.plusDays(expectedProduction_days);
        return delivery_date;
    } 
}