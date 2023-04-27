package ma.bakery;

import ma.bakery.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BakeryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakeryServiceApplication.class, args);
        for (String arg : args){
            System.out.println(arg);
        }
    }


    @Bean
    CommandLineRunner runner(){
        return args -> {
          var bakery = new Bakery();
          bakery.setName("Bakery Marrakesh");
          bakery.setBusiness_phone("066666666666666");
          bakery.setAddress(
                  new Address(
                    null,"31","12","Tanger","streeeeet","91030"
                  )
          );
          bakery.setFounder(
                  new Founder(
                    null , "Mounir El Bakkali","mounirelbakkali","12345","0666666666"
                  )
          );
          bakery.setCreated_at(new Date());

        /*  bakery.setOpeningHours(
                  List.of(
                          new OpeningHours(
                                  null,
                                  Day.MONDAY,
                                  Time._8,
                                  Time._18
                          )
                  )
          );*/
        };
    }

}
