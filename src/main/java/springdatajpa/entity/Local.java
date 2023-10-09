package springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "manager")
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
    @OneToOne(cascade = CascadeType.PERSIST,
              optional = false)
    @JoinColumn(name = "manager_id",
                referencedColumnName = "id")
    private Manager manager;

    /*    @OneToMany(cascade = CascadeType.PERSIST,
                   fetch = FetchType.EAGER)
        @JoinColumn(
                name = "local_id",
                referencedColumnName = "id"
        )
        private List<Order> orderList;*/

    @ManyToMany(cascade = {CascadeType.PERSIST},
                fetch = FetchType.EAGER)
    @JoinTable(name = "local_customer_rel",
               joinColumns = @JoinColumn(name = "local_id",
                                         referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "customer_id",
                                                referencedColumnName = "id"))
    private List<Customer> customers;

}