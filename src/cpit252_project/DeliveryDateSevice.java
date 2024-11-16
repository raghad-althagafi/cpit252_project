package cpit252_project;


import java.time.LocalDate;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author basma
 */
public class DeliveryDateSevice {
    private LocalDate deliveryDate;

    public void calculateDeliveryDate(boolean isUrgent) {
        Scanner input = new Scanner(System.in);

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