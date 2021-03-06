package milos.springframework.milospetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER) // many to many default is LAZY init, when EAGER is up it means
                                            // that JPA is going to load all data at once
                                        // LAZY gets data when its asked for it
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
                                        inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

}
