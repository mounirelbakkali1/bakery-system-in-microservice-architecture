package ma.deliveryservice.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;
    @Column(nullable = false)
    private String  name ;
    @Column(nullable = false)
    @Size(min = 3,message = "username should contain at least 3 characters ")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "username should be composed only by letters and numbers")
    // @UniqueUsername
    private String username ;
    @Column(nullable = false)
    @Size(min = 8,message = "password should be at least 8 length")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",message = "password should obligatory contain at least one uppercase one lowercase and one number ")
    private String password ;
}