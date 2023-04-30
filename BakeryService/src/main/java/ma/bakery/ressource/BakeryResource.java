package ma.bakery.ressource;


import io.swagger.annotations.ApiParam;
import ma.bakery.entities.Bakery;
import ma.bakery.services.BakeryService;
import ma.bakery.utilities.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BakeryResource {


    @Autowired
    BakeryService service ;


    @PostMapping(value =  "/v1/bakery",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<Object> createBakery(@RequestBody @Valid Bakery bakery){
        service.createBakery(bakery);
        return new ResponseEntity<>(new CustomResponse<Bakery>("bakery added successfully",bakery),HttpStatus.CREATED);
    }

    @GetMapping("/v1/bakery")
    public ResponseEntity<Object> findAllBakeries(){
        return ResponseEntity.ok().body(new CustomResponse<>("bakeries retrieved successfully",service.findAllBakeries()));
    }

    @GetMapping("/v1/bakery/{id}")
    public ResponseEntity<Object> getBakery(@PathVariable Long id){
        var bakery = service.findBakery(id);
        if (bakery.isEmpty()) return ResponseEntity.status(404).body(new CustomResponse<String>("No bakery found with id "+id,null));
        CustomResponse<Bakery> response = new CustomResponse<>("bakery retrieved successfully", bakery.get());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/v2/bakery/{id}")
    public ResponseEntity<Object> getBakeryV2(@PathVariable Long id){
        return ResponseEntity.accepted().body("V2 :)");
    }

    @DeleteMapping("/v1/bakery/{id}")
    public ResponseEntity<Object> deleteBakery(
            @ApiParam(
            name = "id of bakery to delete",
            required = true)
            @PathVariable Long id){
        var b = service.findBakery(id);
        if(b.isEmpty()) return ResponseEntity.badRequest().body(new CustomResponse<String>("Enable to delete bakery with id "+id +" (bakery not found)",null));
        service.deleteBakery(id);
        CustomResponse<Bakery> response = new CustomResponse<>("bakery with id: " + id + " deleted successfully", b.get());
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/v1/bakery/{id}")
    public ResponseEntity<Object> updateBakery(@RequestBody @Valid Bakery bakery ,@PathVariable Long id){
        var b = service.findBakery(id);
        if (b.isEmpty())return ResponseEntity.badRequest().body(new CustomResponse<String>("Enable to update bakery with id "+id +" (bakery not found)",null));
        bakery.setId(id);
        var updatedBakery = service.updateBakery(bakery);
        CustomResponse<Bakery> response = new CustomResponse<>("bakery with id: " + id + " updated successfully", updatedBakery);
        return ResponseEntity.status(200).body(response);
    }

   @ExceptionHandler(RuntimeException.class)
   public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
       return ResponseEntity
               .status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body("An error occurred: " + ex.getMessage());
   }

}
