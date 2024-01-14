package api.apiuser.api.repository.model;


import api.apiuser.api.utilities.UsersRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@Setter
@Table(name = "user_cnpj")
@AllArgsConstructor
@NoArgsConstructor
public class UserCnpjModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cnpj_id", unique = true)
    private String id;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "corporate_reason", nullable = false)
    private String corporateReason;

    @Column(name = "name_fantasy")
    private String nameFantasy;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "branch")
    private String branch;

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

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<AddressModel> addressList;

    public UserCnpjModel(String cnpj, String branch, String email, List<AddressModel> addressList, String corporateReason, String nameFantasy, String encryptedPassword){
        this.cnpj = cnpj;
        this.branch = branch;
        this.email = email;
        this.addressList = addressList;
        this.corporateReason = corporateReason;
        this.nameFantasy = nameFantasy;
        this.password = encryptedPassword;

    }

    public UsersRole getUsersRole(){
        return UsersRole.toEnum(this.role);
    }


}
