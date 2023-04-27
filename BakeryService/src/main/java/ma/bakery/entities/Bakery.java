package ma.bakery.entities;


import io.vavr.match.annotation.Patterns;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Bakery {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id ;
    private String name ;
    @OneToOne
    @JoinColumn(name = "address_id",nullable = false)
    private Address address ;
    @ManyToOne
    @JoinColumn(name = "founder_id")
    private Founder founder ;
    @Temporal(value = DATE)
    private Date created_at;
    private String business_phone ;
    private byte[] primary_image ;
    @ElementCollection
    private List<byte[]> images  = new ArrayList<>();
    @OneToMany(targetEntity = OpeningHours.class)
    List<OpeningHours> openingHours = new ArrayList<>();
}
