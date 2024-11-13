/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author shaha
 */
public class Invoice implements OrderBuilder {

    private Order order;
    private final AbstractFactory garmentFactory;
    private final AbstractFactory fabricFactory;
//    private final PriceContext priceContext;

    public Invoice() {
        this.order = new Order();
        this.garmentFactory = FactoryProducer.getFactory("garment");
        this.fabricFactory = FactoryProducer.getFactory("Fabric");
//        this.priceContext = new PriceContext(new StandardPricingStrategy());
    }

    @Override
    public OrderBuilder buildCustomer(Customer customer) {
        order.setCustomer(customer);
        return this;
    }

    @Override
    public OrderBuilder buildGarment(String garmentType) {
        Garment garment = garmentFactory.getGarment(garmentType);
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
    public OrderBuilder buildDate(LocalDate date) {
        order.setTime(date);
        return this;
    }

    @Override
    public OrderBuilder buildPrice(double price) {
        order.setTotalPrice(order.getCustomer().checkDiscount(order.getCustomer(), price));
        //order.setTotalPrice( price);

//        order.setTotalPrice(priceContext.executePricingStrategy(order.getGarment().getType(), meter, order.getFabric().getMaterial()));
        //order.setTotalPrice(order.getCustomer().checkDiscount(order.getCustomer(), priceContext.executePricingStrategy(order.getGarment().getType(), meter, order.getFabric().getMaterial())));
        return this;
    }

    @Override
    public Order buildOrder() {
        Order builtOrder = this.order;
        //this.order = new Order();
        //return builtOrder;
        return order;
    }
}
