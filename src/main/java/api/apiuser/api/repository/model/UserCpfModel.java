package api.apiuser.api.repository.model;

import api.apiuser.api.utilities.UsersRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CollectionType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Cpf")
public class UserCpfModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cpf_id", unique = true)
    private String id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

//    @Column(name = "profile", nullable = false)
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Integer> profile = new HashSet<>();

    @NotNull(message = "O LAST-LOGIN é obrigatório!")
    @Column(name = "last_login", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastLogin;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToOne
    private AddressModel address;


}
