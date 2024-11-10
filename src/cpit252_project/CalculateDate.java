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
    
     public LocalDate calculateDeliveryDate(int durationDays) {
        return LocalDate.now().plusDays(durationDays);
    
}
}