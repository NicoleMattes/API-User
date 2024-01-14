package api.apiuser.api.service;

import api.apiuser.api.dto.UserTokenDto;
import api.apiuser.api.exception.BadRequestException;
import api.apiuser.api.infra.security.JWTUtil;
import api.apiuser.api.repository.UserCnpjRepository;
import api.apiuser.api.repository.UserCpfRepository;
import api.apiuser.api.repository.model.UserCnpjModel;
import api.apiuser.api.repository.model.UserCpfModel;
import api.apiuser.api.request.UserLoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserCnpjRepository userCnpjRepository;
    private UserCpfRepository userCpfRepository;
    private JWTUtil jwtUtil;

    public UserTokenDto loginCnpj(UserLoginRequest request){
        UserCnpjModel user = userCnpjRepository.findByEmail(request.getEmail());

        if(user.getPassword().equals(request.getPassword())){
             UserTokenDto userTokenDto = UserTokenDto.builder()
                    .token(jwtUtil.generateToken(request.getEmail()))
                    .role(user.getRole())
                    .type("CNPJ")
                    .userName(user.getUserName())
                    .build();

            return userTokenDto;
        }
        throw new BadRequestException("Email ou senha invalidos");
    }

    public UserTokenDto loginCpf(UserLoginRequest request){
        UserCpfModel user = userCpfRepository.findByEmail(request.getEmail());

        if(user.getPassword().equals(request.getPassword())){
            UserTokenDto userTokenDto = UserTokenDto.builder()
                    .token(jwtUtil.generateToken(request.getEmail()))
                    .role(user.getRole())
                    .type("CPF")
                    .userName(user.getUserName())
                    .build();

            return userTokenDto;
        }
        throw new BadRequestException("Email ou senha invalidos");
    }
}
