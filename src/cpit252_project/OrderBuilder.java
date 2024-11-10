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
public interface OrderBuilder {
    public OrderBuilder buildCustomer(Customer customer);
    public OrderBuilder buildGarment(String garmentType);
    public OrderBuilder buildFabric(String fabricType);
    public OrderBuilder buildDate(CalculateDate date);
    public OrderBuilder calculatePrice();
    public Order buildOrder();
}
