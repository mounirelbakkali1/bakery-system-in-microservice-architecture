package ma.bakery.ressource;


import ma.bakery.entities.Bakery;
import ma.bakery.services.BakeryService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bakery")
public class BakeryResource {


    @Autowired
    BakeryService service ;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public Bakery createBakery(@RequestBody @Valid Bakery bakery){
        return service.createBakery(bakery);
    }

    // controller-level exception handler
    @ExceptionHandler({PropertyValueException.class})
    public void handleValidation(){
        System.err.println("an Error ACCURRATE when saving a Bakery");
    }

}
