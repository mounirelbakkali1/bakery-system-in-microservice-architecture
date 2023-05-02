package ma.orderservice.services;


import ma.orderservice.entities.Courier;
import ma.orderservice.entities.Order;
import ma.orderservice.entities.Status;
import ma.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;


    @Override
    public Order placeOrder(Order order){
       return  repository.save(order);
    }

    // invoked by th e bakery
    @Override
    public void acceptOrder(Order order){
        repository.acceptOrder(order.getId());
        // TODO : Notify client
        //    ->  notify courier
    }

    @Override
    public void delegateOrder(Order order , Courier courier){
            courier.addToOrdersList(order);
            // TODO : Notify client
    }

    @Override
    public List<Order> findRecentOrders() {
        return repository.findAll()
                .stream()
                .filter(order -> order.getOrderDate().getDayOfMonth()
                        == LocalDateTime.now().getDayOfMonth())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersNearMe(){
        return repository
                .findAll()
                .stream()
                .filter(order -> order.getStatus().equals(Status.ACCEPTED))
                .filter(order -> order
                        .getOrderDate()
                        .getDayOfMonth()
                        == LocalDateTime.now().getDayOfMonth()
                        )
                .collect(Collectors.toList());
    }



}
