package ma.bakery.services;

import ma.bakery.entities.Bakery;
import ma.bakery.repositories.BakeryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@DataJpaTest
class BakeryServiceTest {

    @Autowired
    BakeryRepository repository ;

    @Test
    @Transactional
    void souldSaveABakery() {
        Bakery b = repository.save(
                Bakery
                        .builder()
                        .name("name")
                        .build()
        );
        assertEquals(b.getName(),"name");
    }
}