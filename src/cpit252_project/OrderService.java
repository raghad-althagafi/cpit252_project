package cpit252_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class OrderService {

    private static Scanner input;
    static ArrayList<Order> Orders = new ArrayList<>();
    private CustomerService customerService;
    private OrderBuilder orderBuilder;
    private OrderDirector orderDirector;
    private Order order;
    private PricingSevice Pricingsevice;
    private DeliveryDateSevice deliveryDateSevice;

    public OrderService() {
        this.customerService = new CustomerService();
        this.orderBuilder = new Invoice();
        this.orderDirector = new OrderDirector(orderBuilder);
        this.input = new Scanner(System.in);
        this.Pricingsevice = new PricingSevice();
        this.deliveryDateSevice = new DeliveryDateSevice();
    }

    public String makeOrder() {
        Customer customer = customerService.addCustomer();
        Pricingsevice.calculatePricing();
        String garment = Pricingsevice.getGarmentType();
        String fabric = Pricingsevice.getFabricType();
        deliveryDateSevice.calculateDeliveryDate();
        LocalDate deliveryDate = deliveryDateSevice.getDeliveryDate();
        double finalPrice = Pricingsevice.getFinalPrice();
        orderDirector.makeOrder(customer, fabric, garment, deliveryDate, finalPrice);
        Order order = orderDirector.getOrder();
        Orders.add(order);
        return (order.GenerateInvoice());
    }
}
