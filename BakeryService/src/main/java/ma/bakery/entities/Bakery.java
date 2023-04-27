package ma.bakery.entities;


import lombok.*;

import javax.persistence.*;
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
    private String name ;
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "address_id")
    private Address address ;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "founder_id")
    private Founder founder ;
    @Temporal(value = DATE)
    private Date created_at;
    private String business_phone ;
    private byte[] primary_image ;
    @ElementCollection
    private List<byte[]> images  = new ArrayList<>();
   @OneToMany(fetch = FetchType.EAGER,cascade =ALL)
    List<OpeningHours> openingHours = new ArrayList<>();



   @PrePersist
    private void setCreatedAt(){
       this.created_at = new Date()  ;
   }
}
