package ma.bakery.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;
    @NotBlank
    private String longitude ;
    @NotBlank
    private String latitude ;
    @NotBlank
    private String city ;
    @NotBlank
    private String street ;
    @NotBlank
    private String zip_code ;
}