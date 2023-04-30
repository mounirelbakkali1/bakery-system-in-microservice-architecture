package ma.bakery.ressource;


import io.swagger.annotations.ApiParam;
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
        var bakery = service.findBakery(id);
        if (bakery.isEmpty()) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(bakery.get(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBakery(
            @ApiParam(
            name = "id of bakery to delete",
            required = true)
            @PathVariable Long id){
        if(this.service.findBakery(id).isEmpty()) return ResponseEntity.badRequest().body("bakery not found");
        service.deleteBakery(id);
        return ResponseEntity.accepted().body(
                "deleted successfully"
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBakery(@PathVariable Long id){
        if (this.service.findBakery(id).isEmpty())return ResponseEntity.badRequest().body("bakery not found");
        service.updateBakery(id);
        return ResponseEntity.accepted().body("updated successfuly");
    }

   @ExceptionHandler(RuntimeException.class)
   public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
       return ResponseEntity
               .status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body("An error occurred: " + ex.getMessage());
   }

}
