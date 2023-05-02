package ma.orderservice.resources;


import ma.orderservice.entities.Order;
import ma.orderservice.services.OrderService;
import ma.orderservice.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderResource {
    final String prefix = "/api/v1/orders";
    @Autowired
    OrderService orderService;




    @GetMapping(name = prefix)
    public List<Order> findRecentOrders(){
        return   null ;
    }
}
