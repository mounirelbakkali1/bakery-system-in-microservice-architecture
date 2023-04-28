package ma.bakery.entities;


import lombok.*;
import ma.bakery.utilities.annotations.ValueOfEnum;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Bakery {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id ;
    @NotBlank(message = "name of bakery is required")
    private String name ;
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "address_id")
    @NotNull(message = "Address of bakery (lo,la , city , street , zipcode ) is required")
    private Address address ;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "founder_id")
    @NotNull(message = "Founder is required")
    private Founder founder ;
    @Temporal(value = DATE)
    private Date created_at;
    @NotBlank(message = "business phone should be provided")
    @Digits(message = "phone number is invalid (should contain 10 digits)", integer = 10, fraction = 0)
    private String business_phone ;
    private byte[] primary_image ;
    @ElementCollection
    private List<byte[]> images  = new ArrayList<>();
   @OneToMany(fetch = FetchType.EAGER,cascade =ALL)
    List<OpeningHours> openingHours = new ArrayList<>();


   @Column(name = "bakery_status",nullable = false)
   @Enumerated(EnumType.STRING)
   private BakeryStatus bakeryStatus;



   @PrePersist
    private void setDefaultValues(){
       this.created_at = new Date();
       this.bakeryStatus = BakeryStatus.OPENED;
   }
}
