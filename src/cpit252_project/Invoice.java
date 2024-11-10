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
public class Invoice implements OrderBuilder{

    private Order order;
    private final AbstractFactory garmentFactory;
    private final AbstractFactory fabricFactory;

    public Invoice() {
        this.order = new Order();
        this.garmentFactory = FactoryProducer.getFactory("garment");
        this.fabricFactory = FactoryProducer.getFactory("Fabric");
    }

    @Override
    public OrderBuilder buildCustomer(Customer customer) {
        order.setCustomer(customer);
        return this;
    }

    @Override
    public OrderBuilder buildGarment(String garmentType) {
        Garment garment = garmentFactory.getGarment("garmentType");
        order.setGarment(garment);
        return this;
    }

    @Override
    public OrderBuilder buildFabric(String fabricType) {
        Fabric fabric = fabricFactory.getFabric(fabricType);
        order.setFabric(fabric);
        return this;
    }

    @Override
    public OrderBuilder buildDate(CalculateDate date) {
        order.setTime(date);
        return this;
    }

    @Override
    public OrderBuilder calculatePrice() {
        //order.setTotalPrice(order.getCustomer().checkDiscount(order.getCustomer(), .getPrice()));
        return this;
    }

    @Override
    //to reuse the builder in the  do-while loop
    public Order buildOrder() {
        Order builtOrder = this.order;
        this.order = new Order();
        return builtOrder;
    }
}
