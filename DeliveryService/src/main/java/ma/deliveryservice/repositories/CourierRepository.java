package ma.deliveryservice.repositories;

import ma.deliveryservice.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourierRepository extends JpaRepository<Courier,Long> {
}
