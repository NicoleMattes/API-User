package api.apiuser.api.repository.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Address_id", unique = true)
    private String id;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "public_place", nullable = false)
    private String publicPlace;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @OneToOne(orphanRemoval = true)
    private UserCpfModel userCpf;
}
