package api.apiuser.api.service;

import api.apiuser.api.exception.ForbiddenException;
import api.apiuser.api.infra.security.UserDetailsSecurity;
import api.apiuser.api.mapper.UserCpfMapper;
import api.apiuser.api.repository.UserCpfRepository;
import api.apiuser.api.repository.model.UserCpfModel;
import api.apiuser.api.request.UserCpfRequest;
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
public class UserCpfService {
    @Autowired
    private final UserCpfRepository userCpfRepository;

    private final PasswordEncoder criptoSenha = new BCryptPasswordEncoder();

    public UserCpfModel createdNewUser(UserCpfRequest request){
        UserDetailsSecurity userDetailsSecurity = UserDetailsSecurityService.authenticated();
        if(Objects.isNull(userDetailsSecurity) || userDetailsSecurity.hasRole(UsersRole.ADMIN)){
            throw new ForbiddenException("Acesso Negado");
        }

        String encoderPassword = this.criptoSenha.encode(request.getPassword());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        UserCpfModel userCpfModel = UserCpfModel.builder()
                .cpf(request.getCpf())
                .userName(request.getUserName())
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .lastLogin(timestamp)
                .password(encoderPassword)
                .lastLogin(timestamp)
                .build();

        userCpfRepository.save(userCpfModel);
        return userCpfModel;
    }



    public UserCpfModel getUserCpf(String id){
        UserCpfModel userCpfModel = userCpfRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + id));
        return userCpfModel;
    }

    public UserCpfModel updateUserCpf(String id, UserCpfRequest request){
        UserCpfModel userCpfModel = userCpfRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + id));

        userCpfModel.setCpf(request.getCpf());
        userCpfModel.setUserName(request.getUserName());
        userCpfModel.setEmail(request.getEmail());
        userCpfModel.setPassword(request.getPassword());
        userCpfModel.setAddress(request.getAddress());

        return userCpfRepository.save(userCpfModel);
    }

    public UserCpfModel deleteUserCnpj(String id) {
        UserCpfModel userCnpjModel = userCpfRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + id));

        userCpfRepository.deleteById(id);

        return userCnpjModel;
    }
}
