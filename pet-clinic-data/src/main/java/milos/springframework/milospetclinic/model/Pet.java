package milos.springframework.milospetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id") // every pet have type
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id") // every pet have owner
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet") // if we delete pet all visits will be deleted too
    // pet can have many visits
    private Set<Visit> visits = new HashSet<>();

}
