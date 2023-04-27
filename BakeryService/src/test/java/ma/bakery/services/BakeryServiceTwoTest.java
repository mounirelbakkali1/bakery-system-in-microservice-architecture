package ma.bakery.services;

import ma.bakery.entities.Bakery;
import ma.bakery.repositories.BakeryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BakeryServiceTwoTest {

    @Autowired
    BakeryService service;

    @Test
    @Transactional
    void souldSaveABakery() {
        Bakery b = service.saveBakery();
        assertEquals(b.getName(),"bakery kesh");
    }
}