package ma.deliveryservice.services;


import ma.deliveryservice.entities.Courier;
import ma.deliveryservice.repositories.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourierService {

    @Autowired
    CourierRepository repository ;

    public List<Courier> findAllCouriers() {
        return repository.findAll();
    }

    public List<Courier> findAvailableCouriers() {
        return repository.findAll()
                .stream()
                .filter(courier -> courier.getAdminDocument().isVerified())
                .filter(Courier::isAvailable)
                .collect(Collectors.toList());
    }

    public Courier saveCourier(Courier courier) {
        return repository.save(courier);
    }
}
