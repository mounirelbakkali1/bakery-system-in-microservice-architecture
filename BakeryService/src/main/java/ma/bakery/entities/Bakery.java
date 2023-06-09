package ma.bakery.entities;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ma.bakery.utilities.annotations.ValueOfEnum;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    // required to be shown in the docs
    @ApiModelProperty(required = true)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "bakery name should be composed only by letters and numbers")
    private String name ;
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "address_id")
    @ApiModelProperty(required = true)
    @NotNull(message = "Address of bakery (lo,la , city , street , zipcode ) is required")
    private Address address ;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "founder_id")
    @NotNull(message = "Founder is required")
    @ApiModelProperty(required = true)
    private Founder founder ;
    @Temporal(value = DATE)
    private Date created_at;
    @NotBlank(message = "business phone should be provided")
    @ApiModelProperty(required = true)
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
       if(null != this.bakeryStatus) this.bakeryStatus = BakeryStatus.OPENED;
   }
}
