package springdatajpa.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Address {
    private String city;
    private String mainStreet;
    private String secondaryStreet;
}
