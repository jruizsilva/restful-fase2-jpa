package springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customers",
       uniqueConstraints = @UniqueConstraint(
               name = "email_unique",
               columnNames = "email_address"
       ))
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence",
                       sequenceName = "customer_sequence",
                       allocationSize = 1)
    @GeneratedValue(generator = "customer_sequence",
                    strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false)
    private String email;

    /*private String city;
    private String mainStreet;
    private String secondaryStreet;*/

    @Embedded
    private Address address;
}