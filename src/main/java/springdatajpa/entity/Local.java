package springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "locals")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;
    private String name;
    private String floor;

    @OneToOne(cascade = {CascadeType.PERSIST},
              fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    /*@ToString.Exclude*/
    private Manager manager;
}