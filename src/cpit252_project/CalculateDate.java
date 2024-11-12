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
public class CalculateDate implements DeliveryDate {
    LocalDate date;
     public LocalDate calculateDeliveryDate(int expectedProduction_days) {
          date  = LocalDate.now().plusDays(expectedProduction_days);
          return date;
}

    public LocalDate getDate() {
        return date;
    }

   
     
}