package api.apiuser.api.mapper;

import api.apiuser.api.dto.AddressDto;
import api.apiuser.api.dto.UserCnpjDto;
import api.apiuser.api.repository.model.AddressModel;
import api.apiuser.api.repository.model.UserCnpjModel;
import api.apiuser.api.request.UserCnpjRequest;

import java.util.ArrayList;
import java.util.List;

public class UserCnpjMapper {

    private UserCnpjRequest request;


    public static UserCnpjModel toUserCnpjModel(UserCnpjRequest request, String encoderPassword){
        return UserCnpjModel.builder()
                .cnpj(request.getCnpj())
                .corporateReason(request.getCorporateReason())
                .nameFantasy(request.getNameFantasy())
                .email(request.getEmail())
                .branch(request.getBranch())
                .password(encoderPassword)
                .addressList(request.getAddressList())
                .role(request.getRole())
                .build();

    }

    public static UserCnpjDto toUserCnpjDto(UserCnpjModel userCnpjModel){
        UserCnpjDto dto = new UserCnpjDto();
        dto.setId(userCnpjModel.getId());
        dto.setEmail(userCnpjModel.getEmail());
        dto.setCnpj(userCnpjModel.getCnpj());
        dto.setBranch(userCnpjModel.getBranch());
        dto.setNameFantasy(userCnpjModel.getNameFantasy());
        dto.setRole(userCnpjModel.getRole());
        List<AddressDto> addressDtoList = new ArrayList<>();
        for (AddressModel addressModel : userCnpjModel.getAddressList()) {
            AddressDto addressDto = AddressMapper.toAddressDto(addressModel);
            addressDtoList.add(addressDto);
        }
        dto.setAddressDtoList(addressDtoList);
        return dto;
    }
}
