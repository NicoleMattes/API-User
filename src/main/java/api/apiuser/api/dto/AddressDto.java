package api.apiuser.api.dto;

import api.apiuser.api.repository.model.AddressModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String id;
    private String cep;
    private String publicPlace;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;

    public static AddressDto fromAddresModel(AddressModel addressModel){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(addressModel.getId());
        addressDto.setPublicPlace(addressModel.getPublicPlace());
        addressDto.setNeighborhood(addressModel.getNeighborhood());
        addressDto.setNumber(addressModel.getNumber());
        addressDto.setCountry(addressModel.getCountry());
        addressDto.setCity(addressModel.getCity());
        addressDto.setState(addressDto.getState());
        addressDto.setCep(addressModel.getCep());
        return addressDto;
    }
}
