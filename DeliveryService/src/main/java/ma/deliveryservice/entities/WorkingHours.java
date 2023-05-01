package ma.deliveryservice.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "working_hours")
@Builder
@ToString
public class WorkingHours {
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
