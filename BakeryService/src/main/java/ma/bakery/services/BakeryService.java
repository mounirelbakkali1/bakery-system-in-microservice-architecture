package ma.bakery.services;


import ma.bakery.entities.Bakery;
import ma.bakery.repositories.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BakeryService {
    @Autowired
    BakeryRepository bakeryRepository ;


    @Transactional
    public Bakery saveBakery(){
        Bakery bakery = new Bakery();
        bakery.setName("bakery kesh");
        var b = bakeryRepository.save(bakery);
        return b ; 
    }
}
