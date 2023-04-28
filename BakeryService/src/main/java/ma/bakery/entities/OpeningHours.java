package ma.bakery.entities;

import lombok.*;
import ma.bakery.utilities.annotations.ValueOfEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "opening_hours")
@Builder
@ToString
public class OpeningHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = true)
    private Long id;
    @NotBlank
    @ValueOfEnum(enumClass = Day.class)
    @Enumerated(EnumType.STRING)
    private Day day  ;
    @ValueOfEnum(enumClass = Time.class)
    @Enumerated(EnumType.STRING)
    private Time from ;
    @ValueOfEnum(enumClass = Time.class)
    @Enumerated(EnumType.STRING)
    private Time to ;
}