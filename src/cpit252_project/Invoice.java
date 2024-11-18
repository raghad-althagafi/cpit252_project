

package cpit252_project;

import java.time.LocalDate;

public class Invoice implements OrderBuilder {

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
        return this;
    }

    @Override
    public Order buildOrder() {
        return this.order;
    }
}
