package api.apiuser.api.mapper;
import api.apiuser.api.dto.UserCpfDto;
import api.apiuser.api.repository.model.UserCpfModel;
import api.apiuser.api.request.UserCpfRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UserCpfMapper {
    @Autowired
    private final PasswordEncoder criptoSenha = new BCryptPasswordEncoder();

    private UserCpfRequest request;

    String encoderPassword = this.criptoSenha.encode(request.getPassword());
    String encoderSecurity = this.criptoSenha.encode(request.getPassword());

    public static UserCpfModel toUserCpfModel(UserCpfRequest request, String encoderPassword){
        return UserCpfModel.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .password(encoderPassword)
                .address(request.getAddress())
                .role(request.getRole())
                .build();
    }

    public static UserCpfDto toUserDto(UserCpfModel userCpf){
        UserCpfDto dto = new UserCpfDto();
        dto.setId(userCpf.getId());
        dto.setName(userCpf.getName());
        dto.setEmail(userCpf.getEmail());
        dto.setRole(userCpf.getRole());
        return dto;
    }
}
