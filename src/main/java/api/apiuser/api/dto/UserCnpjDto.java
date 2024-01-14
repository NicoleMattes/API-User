package api.apiuser.api.dto;

import api.apiuser.api.repository.model.UserCnpjModel;
import api.apiuser.api.utilities.UsersRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCnpjDto {
    private String id;
    private String cnpj;
    private String corporateReason;
    private String nameFantasy;
    private String email;
    private String branch;
    private List<AddressDto> addressDtoList;
    private String role;

    public static UserCnpjDto fromUserCnpjModel(UserCnpjModel userCnpjModel){
        UserCnpjDto userCnpjDto = new UserCnpjDto();
        userCnpjDto.setId(userCnpjDto.getId());
        userCnpjDto.setCnpj(userCnpjDto.getCnpj());
        userCnpjDto.setBranch(userCnpjDto.getBranch());
        userCnpjDto.setCorporateReason(userCnpjDto.getCorporateReason());
        userCnpjDto.setEmail(userCnpjDto.getEmail());
        userCnpjDto.setRole(userCnpjDto.getRole());
        userCnpjDto.setAddressDtoList(userCnpjDto.getAddressDtoList());
        return userCnpjDto;
    }
}
