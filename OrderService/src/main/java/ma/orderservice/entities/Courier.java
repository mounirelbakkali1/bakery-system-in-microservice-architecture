package ma.orderservice.entities;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Courier {
     String id ;
     String name ;

     List<Order> orderList = new ArrayList<>();



    public void addToOrdersList(Order order){
        orderList.add(order);
    }
}
