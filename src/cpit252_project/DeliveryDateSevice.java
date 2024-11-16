package cpit252_project;


import java.time.LocalDate;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rafa
 */
public class DeliveryDateSevice {
    private LocalDate deliveryDate;
    private boolean isUrgent;

    public void calculateDeliveryDate() {
        Scanner input = new Scanner(System.in);
        
  // Check if the order is urgent
        System.out.println("Is the order urgent? yes=1 / no=2");
        int isUrgentChoice = input.nextInt();
        isUrgent = (isUrgentChoice == 1);
        
        System.out.println("Enter the Expected production date (in days):");
        int expectedProductionDays = input.nextInt();

        DeliveryDate deliveryDateCalculator = new CalculateDate();

        if (isUrgent) {
            UrgentDateDecorator rushDecorator = new UrgentDateDecorator(deliveryDateCalculator, 2); // e.g., 2-day rush
            deliveryDateCalculator = rushDecorator;
        }

        deliveryDate = deliveryDateCalculator.calculateDeliveryDate(expectedProductionDays);
        System.out.println("Delivery Date: " + deliveryDate);
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
}