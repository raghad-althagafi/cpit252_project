

package cpit252_project;

import java.time.LocalDate;


public interface OrderBuilder {
    public OrderBuilder buildCustomer(Customer customer);
    public OrderBuilder buildGarment(String garmentType);
    public OrderBuilder buildFabric(String fabricType);
    public OrderBuilder buildDate(LocalDate date);
    public OrderBuilder buildPrice(double price);
    public Order buildOrder();
}
