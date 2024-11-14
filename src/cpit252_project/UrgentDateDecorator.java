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
public class UrgentDateDecorator extends DateDecorator {
    
    public UrgentDateDecorator(DeliveryDate baseCalculator, int rushDays) {
        super(baseCalculator, rushDays);
    }
       @Override
    public LocalDate calculateDeliveryDate(int durationDays) {
        return baseCalculator.calculateDeliveryDate(durationDays - rushDays);
    }
    
   public boolean isUrgent() {
        return isUrgent;
    }
    
}
