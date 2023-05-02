package ma.orderservice.services;

import ma.orderservice.entities.Courier;
import ma.orderservice.entities.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findRecentOrders();
    public List<Order> findOrdersNearMe();
    public Order placeOrder(Order order);
    public void acceptOrder(Order order);
    public void delegateOrder(Order order , Courier courier);
}
