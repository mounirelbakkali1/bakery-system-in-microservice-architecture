package ma.bakery.ressource;


import ma.bakery.entities.Bakery;
import ma.bakery.services.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bakery")
public class BakeryResource {


    @Autowired
    BakeryService service ;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public Bakery createBakery(@RequestBody Bakery bakery){
        return service.createBakery(bakery);
    }
}
