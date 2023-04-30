package ma.bakery.services;


import ma.bakery.entities.*;
import ma.bakery.repositories.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BakeryService {
    @Autowired
    BakeryRepository bakeryRepository ;


    public List<Bakery> findAllBakeries(){
        return bakeryRepository.findAll();
    }


    @Transactional
    public Bakery saveBakery(){
        Bakery bakery = Bakery.builder()
                .name("bakery kesh")
                .business_phone("06666666666")
                .address(Address.builder()
                        .city("Marrakesh")
                        .street("street")
                        .latitude("32")
                        .longitude("12")
                        .zip_code("17000")
                        .build())
                .founder(Founder.builder()
                        .name("mounir")
                        .username("mounir1")
                        .password("Mpq12345")
                        .build())
                .openingHours(List.of(
                        OpeningHours.builder()
                                .day(Day.MONDAY)
                                .from(Time._8)
                                .to(Time._17)
                                .build(),
                        OpeningHours.builder()
                                .day(Day.TUESDAY)
                                .from(Time._9)
                                .to(Time._18)
                                .build()
                ))
                .bakeryStatus(BakeryStatus.OPENED)
                .build();
        var b = bakeryRepository.save(bakery);
        return b ;
    }

    @Transactional
    public Bakery createBakery(Bakery bakery){
        return this.bakeryRepository.save(bakery);
    }

    public Optional<Bakery> findBakery(Long id) {
        return bakeryRepository.findById(id);
    }


    @Transactional
    public void deleteBakery(Long id) {
         bakeryRepository.deleteById(id);
    }

    public Bakery updateBakery(Bakery bakery) {
        // TODO :: provide code for update
        //  Load and Save Approach
        //  Mapping Strategy
        //  Custom Query
        return bakeryRepository.updateBakery(bakery);
    }
}
