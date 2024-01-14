package api.apiuser.api.infra.security;

import api.apiuser.api.utilities.UsersRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsSecurity implements UserDetails {

    private String id;
    private String userName;
    private String password;
    private SimpleGrantedAuthority authorities;

    public UserDetailsSecurity(String id, String userName, String password, UsersRole role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = new SimpleGrantedAuthority(role.getDescription());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(UsersRole role){
        return getAuthorities().contains(new SimpleGrantedAuthority(role.getDescription()));
    }
}
