package api.apiuser.api.dto;

import api.apiuser.api.repository.model.UserCpfModel;
import api.apiuser.api.utilities.UsersRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCpfDto {
    private String id;
    private String name;
    private String email;
    private AddressDto address;
    private String role;

    public static UserCpfDto fromUserCpfModel(UserCpfModel userCpfModel){
        UserCpfDto userCpfDto = new UserCpfDto();
        userCpfDto.setId(userCpfModel.getId());
        userCpfDto.setName(userCpfModel.getName());
        userCpfDto.setAddress(AddressDto.fromAddresModel(userCpfModel.getAddress()));
        userCpfDto.setEmail(userCpfModel.getEmail());
        userCpfDto.setRole(userCpfModel.getRole());
        return userCpfDto;
    }

}
