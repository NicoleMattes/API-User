package api.apiuser.api.mapper;

import api.apiuser.api.dto.AddressDto;
import api.apiuser.api.repository.model.AddressModel;
import api.apiuser.api.request.AddressRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AddressMapper {

    public static AddressModel toAddressModel(AddressRequest request){
        return AddressModel.builder()
                .cep(request.getCep())
                .publicPlace(request.getPublicPlace())
                .number(request.getNumber())
                .complement(request.getComplement())
                .neighborhood(request.getNeighborhood())
                .city(request.getCity())
                .state(request.getState())
                .country(request.getCountry())
                .build();
    }

    public static AddressDto toAddressDto(AddressModel addressModel){
        AddressDto dto = new AddressDto();
        dto.setId(addressModel.getId());
        dto.setCep(addressModel.getCep());
        dto.setPublicPlace(addressModel.getPublicPlace());
        dto.setNumber(addressModel.getNumber());
        dto.setNeighborhood(addressModel.getNeighborhood());
        dto.setComplement(addressModel.getComplement());
        dto.setCity(addressModel.getCity());
        dto.setCountry(addressModel.getCountry());
        return dto;
    }

    public static AddressDto fromAddressModelToAddressDto(Optional<AddressModel> addressModel) {
        if (addressModel.isPresent()) {
            AddressModel addressModelNotNull = addressModel.get();
            AddressDto dto = new AddressDto();
            dto.setId(addressModelNotNull.getId());
            dto.setCep(addressModelNotNull.getCep());
            dto.setPublicPlace(addressModelNotNull.getPublicPlace());
            dto.setNumber(addressModelNotNull.getNumber());
            dto.setNeighborhood(addressModelNotNull.getNeighborhood());
            dto.setComplement(addressModelNotNull.getComplement());
            dto.setCity(addressModelNotNull.getCity());
            dto.setCountry(addressModelNotNull.getCountry());

            return dto;
        } else {
            return null;
        }
    }

    public static List<AddressDto> fromAddressModelListToAddressDtoList(List<AddressModel> addressModels) {
        return addressModels.stream()
                .map(AddressMapper::toAddressDto)  // Usa o método toAddressDto para converter cada AddressModel em AddressDto
                .collect(Collectors.toList());
    }

    public static AddressDto fromAddressModelToAddressDtoList(Optional<AddressModel> addressModel) {
        if (addressModel.isPresent()) {
            AddressModel addressModelNotNull = addressModel.get();
            AddressDto dto = new AddressDto();
            dto.setId(addressModelNotNull.getId());
            dto.setCep(addressModelNotNull.getCep());
            dto.setPublicPlace(addressModelNotNull.getPublicPlace());
            dto.setNumber(addressModelNotNull.getNumber());
            dto.setNeighborhood(addressModelNotNull.getNeighborhood());
            dto.setComplement(addressModelNotNull.getComplement());
            dto.setCity(addressModelNotNull.getCity());
            dto.setCountry(addressModelNotNull.getCountry());

            return dto;
        } else {
            return null;
        }
    }
}
