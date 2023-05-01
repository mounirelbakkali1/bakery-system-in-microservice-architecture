package ma.deliveryservice.resources;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ma.deliveryservice.entities.Courier;
import ma.deliveryservice.services.CourierService;
import ma.deliveryservice.utilities.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CourierResource {

    private final String prefix = "/v1/courier";

    @Autowired
    CourierService service ;


    @GetMapping(prefix+"/all")
    public ResponseEntity<Object> findAllCouriers(){
        return ResponseEntity.ok().body(new CustomResponse<>("couriers retrieved successfully",service.findAllCouriers()));
    }

    @GetMapping(prefix+"/available")
    public ResponseEntity<Object> findAllAvailableCouriers(@Param("available") boolean available){
        if (available){
            return ResponseEntity.ok().body(
                    new CustomResponse<>("available couriers list", service.findAvailableCouriers())
            );
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(prefix+"")
    public ResponseEntity<Object> saveCourier(@RequestBody @Valid Courier courier){
       var c = service.saveCourier(courier);
       return ResponseEntity.accepted().body(
               new CustomResponse<>("courier account created successfully",c)
       );
    }
}
