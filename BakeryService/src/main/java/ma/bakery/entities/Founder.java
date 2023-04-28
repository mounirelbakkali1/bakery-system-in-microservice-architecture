package ma.bakery.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity
@ToString(callSuper = true)
@SuperBuilder
public class Founder extends User {

    @Digits(message = "besiness phone of the founder should be provided",integer = 10 , fraction = 0)
    private String business_phone ;

    public Founder() {
    }

    public Founder(Long id, String name, String username, String password, String business_phone) {
        super(id, name, username, password);
        this.business_phone = business_phone;
    }
}