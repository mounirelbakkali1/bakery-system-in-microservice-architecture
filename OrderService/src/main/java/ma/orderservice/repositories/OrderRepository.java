package ma.orderservice.repositories;


import ma.orderservice.entities.Order;
import ma.orderservice.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {



    @Query("UPDATE Order o SET o.status ='ACCEPTED' WHERE o.id = :id")
    void acceptOrder(Long id);
}
