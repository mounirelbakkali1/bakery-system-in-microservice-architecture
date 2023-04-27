package ma.bakery.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpeningHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = true)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Day day  ;
    @Enumerated(EnumType.STRING)
    private Time from ;
    @Enumerated(EnumType.STRING)
    private Time to ;
}