package ma.bakery.services;


import ma.bakery.entities.*;
import ma.bakery.repositories.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BakeryService {
    @Autowired
    BakeryRepository bakeryRepository ;


    @Transactional
    public Bakery saveBakery(){
        Bakery bakery = Bakery.builder()
                .name("bakery kesh")
                .business_phone("06666666666")
                .address(Address.builder()
                        .city("Marrakesh")
                        .latitude("32")
                        .longitude("12")
                        .zip_code("17000")
                        .build())
                .founder(Founder.builder()
                        .name("mounir")
                        .username("mounir1")
                        .password("12345")
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
                .build();
        var b = bakeryRepository.save(bakery);
        return b ;
    }
}
