package ma.bakery.ressource;


import ma.bakery.entities.Bakery;
import ma.bakery.services.BakeryService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Bakery> createBakery(@RequestBody @Valid Bakery bakery){
        return new ResponseEntity<>(service.createBakery(bakery),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBakery(@PathVariable Long id){
        return new ResponseEntity<>(service.findBakery(id).orElse(null),HttpStatus.ACCEPTED);
    }

   @ExceptionHandler(RuntimeException.class)
   public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
       return ResponseEntity
               .status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body("An error occurred: " + ex.getMessage());
   }

}
