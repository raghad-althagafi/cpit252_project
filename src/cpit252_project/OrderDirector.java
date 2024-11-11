/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.time.LocalDate;

/**
 *
 * @author shaha
 */
public class OrderDirector {

    private OrderBuilder orderBuilder;

    public OrderDirector(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public Order getOrder() {
        return this.orderBuilder.buildOrder();
    }

    public Order makeOrder(Customer customer, String fabric, String garment, LocalDate date, double price) {
        return orderBuilder
                .buildCustomer(customer)
                .buildFabric(fabric)
                .buildGarment(garment)
                .buildPrice(price)
                .buildDate(date)
                .buildOrder();
    }
}
