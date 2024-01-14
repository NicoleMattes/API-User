package api.apiuser.api.service;


import api.apiuser.api.entity.UserCnpj;
import api.apiuser.api.infra.security.UserDetailsSecurity;
import api.apiuser.api.repository.UserCnpjRepository;
import api.apiuser.api.repository.UserCpfRepository;
import api.apiuser.api.repository.model.UserCnpjModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserDetailsSecurityService implements UserDetailsService {

    @Autowired
    private UserCnpjRepository userCnpjRepository;

    @Autowired
    private UserCpfRepository userCpfRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserCnpjModel userCnpj = this.userCnpjRepository.findByEmail(email);
        if(Objects.isNull(userCnpj)){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new UserDetailsSecurity(userCnpj.getId(), userCnpj.getUserName(), userCnpj.getPassword(), userCnpj.getUsersRole());
    }

    public static UserDetailsSecurity authenticated(){
        try{
            return (UserDetailsSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e){
            return null;
        }
    }
}
