package api.apiuser.api.service;

import api.apiuser.api.exception.ForbiddenException;
import api.apiuser.api.infra.security.UserDetailsSecurity;
import api.apiuser.api.repository.UserCnpjRepository;
import api.apiuser.api.repository.model.UserCnpjModel;
import api.apiuser.api.request.UserCnpjRequest;
import api.apiuser.api.utilities.UsersRole;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserCnpjService {

    @Autowired
    private final UserCnpjRepository userCnpjRepository;

    private final PasswordEncoder criptoSenha = new BCryptPasswordEncoder();


    public UserCnpjModel createdNewUser(UserCnpjRequest request){
        UserDetailsSecurity userDetailsSecurity = UserDetailsSecurityService.authenticated();
        if(Objects.isNull(userDetailsSecurity) || userDetailsSecurity.hasRole(UsersRole.ADMIN)){
            throw new ForbiddenException("Acesso Negado!");
        }

        String encoderPassword = this.criptoSenha.encode(request.getPassword());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        UserCnpjModel userCnpjModel = UserCnpjModel.builder()
                .cnpj(request.getCnpj())
                .branch(request.getBranch())
                .userName(request.getUserName())
                .email(request.getEmail())
                .nameFantasy(request.getNameFantasy())
                .corporateReason(request.getCorporateReason())
                .addressList(request.getAddressList())
                .password(encoderPassword)
                .lastLogin(timestamp)
                .build();

        userCnpjRepository.save(userCnpjModel);
        return userCnpjModel;
    }

    public UserCnpjModel getUserCnpj(String id){
        UserCnpjModel userCnpjModel = userCnpjRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + id));
        return userCnpjModel;
    }

    public UserCnpjModel updateUserCnpj(String id, UserCnpjRequest request) throws EntityNotFoundException{
        UserCnpjModel userCnpjModel = userCnpjRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + id));

        userCnpjModel.setCnpj(request.getCnpj());
        userCnpjModel.setBranch(request.getBranch());
        userCnpjModel.setUserName(request.getUserName());
        userCnpjModel.setEmail(request.getEmail());
        userCnpjModel.setNameFantasy(request.getNameFantasy());
        userCnpjModel.setCorporateReason(request.getCorporateReason());
        userCnpjModel.setPassword(request.getPassword());
        userCnpjModel.setAddressList(request.getAddressList());

        return userCnpjRepository.save(userCnpjModel);
    }

    public UserCnpjModel deleteUserCnpj(String id) {
        UserCnpjModel userCnpjModel = userCnpjRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + id));

        userCnpjRepository.deleteById(id);

        return userCnpjModel;
    }
}
