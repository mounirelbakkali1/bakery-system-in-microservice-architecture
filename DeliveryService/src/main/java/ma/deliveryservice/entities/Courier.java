package ma.deliveryservice.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

@Entity
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Courier extends User {
    @Digits(message = "besiness phone of the founder should be provided",integer = 10 , fraction = 0)
    private String business_phone ;
    @NotNull
    @OneToMany(fetch = FetchType.EAGER  ,cascade = ALL)
    private List<WorkingHours> workingHours = new ArrayList<>();
    private boolean available ;
    @Column(name = "vehicule_type")
    @Enumerated(STRING)
    private VehiculeType vehiculeType ;
    private String bio ;
    @NotNull
    private byte[] image;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "admin_document_id")
    private AdminDocument adminDocument;


    public Courier(Long id, String name,String username,String password, String business_phone, List<WorkingHours> workingHours, boolean available, VehiculeType vehiculeType, String bio,  byte[] image,AdminDocument adminDocument) {
        super(id, name, username, password);
        this.business_phone = business_phone;
        this.workingHours = workingHours;
        this.available = available;
        this.vehiculeType = vehiculeType;
        this.bio = bio;
        this.image = image;
        this.adminDocument=adminDocument ;
    }
}
