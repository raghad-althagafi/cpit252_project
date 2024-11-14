/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpit252_project;

import java.time.LocalDate;

/**
 *
 * @author rafarezqallah
 */
public abstract class DateDecorator implements DeliveryDate {
    
 final DeliveryDate baseCalculator;
 final int rushDays;
 boolean isUrgent;
 
      public DateDecorator(DeliveryDate baseCalculator, int rushDays) {
        this.baseCalculator = baseCalculator;
        this.rushDays = rushDays;
        this.isUrgent = true; // Flag the order as urgent
    }
      
      @Override
    public LocalDate calculateDeliveryDate(int durationDays) {
        return baseCalculator.calculateDeliveryDate(durationDays - rushDays);
    }
    
   public boolean isUrgent() {
        return isUrgent;
    }
    
}
