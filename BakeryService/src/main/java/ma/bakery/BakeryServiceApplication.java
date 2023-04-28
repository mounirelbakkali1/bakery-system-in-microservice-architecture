package ma.bakery;

import ma.bakery.entities.*;
import ma.bakery.repositories.BakeryRepository;
import ma.bakery.services.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BakeryServiceApplication {

    @Autowired
    BakeryService service ;

    public static void main(String[] args) {
        SpringApplication.run(BakeryServiceApplication.class, args);
        for (String arg : args){
            System.out.println(arg);
        }
    }


    @Bean
    CommandLineRunner runner(){
        return args -> {
           /* Bakery b = service.saveBakery();
            b.getOpeningHours()
                    .forEach(System.out::println);*/
        };
    }

}
