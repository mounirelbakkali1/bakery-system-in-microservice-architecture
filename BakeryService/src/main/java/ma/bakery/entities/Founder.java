package ma.bakery.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
public class Founder extends User {
    private String business_phone ;

    public Founder() {
    }

    public Founder(Long id, String name, String username, String password, String business_phone) {
        super(id, name, username, password);
        this.business_phone = business_phone;
    }
}