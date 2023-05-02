package ma.orderservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order
{
    @Id
    @GeneratedValue
     Long id ;
    @Temporal(TemporalType.DATE)
            @Column(name = "order_date")
     LocalDateTime orderDate;
    @Column(name = "order_status")
    @Enumerated
     Status status;




    @PrePersist
     void init(){
        setOrderDate(LocalDateTime.now());
    }
}
