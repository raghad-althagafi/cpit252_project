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
public class OrderDirector {
    private OrderBuilder orderBuilder;

    public OrderDirector(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public Order getOrder(){
        return this.orderBuilder.buildOrder();
    }

    public Order makeOrder(Customer customer, String fabric, String garment, Delivery_Date date){
        this.orderBuilder.buildCustomer(customer);
        this.orderBuilder.buildFabric(fabric);
        this.orderBuilder.buildGarment(garment);
        this.orderBuilder.calculatePrice();
        this.orderBuilder.buildDate(date);
        return this.orderBuilder.buildOrder();
    }
}
