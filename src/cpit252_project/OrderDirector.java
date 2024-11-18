
package cpit252_project;

import java.time.LocalDate;


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
