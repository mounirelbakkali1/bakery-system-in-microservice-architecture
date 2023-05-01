package ma.deliveryservice.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminDocument {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id ;
    @NotBlank
    @Column(name = "assurance_number")
    private String assuranceNumber ;
    @NotBlank
    @Column(name ="cin_number")
    private String cinNumber ;
    private boolean verified = false ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdminDocument that = (AdminDocument) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
