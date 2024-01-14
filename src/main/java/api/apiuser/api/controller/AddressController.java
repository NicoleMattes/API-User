package api.apiuser.api.controller;

import api.apiuser.api.dto.AddressDto;
import api.apiuser.api.mapper.AddressMapper;
import api.apiuser.api.repository.model.AddressModel;
import api.apiuser.api.request.AddressRequest;
import api.apiuser.api.response.BaseResponseAddress;
import api.apiuser.api.service.AddressService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/address-gx/auth")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    @PostMapping("/register-address")
    public BaseResponseAddress<AddressDto> newAddress(@RequestBody AddressRequest request) throws EntityNotFoundException, UserPrincipalNotFoundException{
        AddressModel addressModel = addressService.newAddress(request);
        AddressDto addressDto = AddressDto.fromAddresModel(addressModel);
        return new BaseResponseAddress<>(HttpStatus.OK.value(), "Address created", addressDto);
    }

    @GetMapping("/getAddressCpf")
    public BaseResponseAddress<AddressDto> getAddressCpf(@RequestParam("cpf") String cpf){
        Optional<AddressModel> addressModel = addressService.findAddressByUserCpf(cpf);
        AddressDto addressDto = AddressMapper.fromAddressModelToAddressDto(addressModel);
        return new BaseResponseAddress<>(HttpStatus.OK.value(), "Address located successfully", addressDto);
    }

    @GetMapping("/getAddressCnpj")
    public BaseResponseAddress<List<AddressDto>> getAddressCnpj(@RequestParam("cnpj") String cnpj) {
        Optional<List<AddressModel>> addressModels = addressService.findAddressByUserCnpj(cnpj);

        if (addressModels.isPresent()) {
            List<AddressDto> addressDtos = AddressMapper.fromAddressModelListToAddressDtoList(addressModels.get());
            return new BaseResponseAddress<>(HttpStatus.OK.value(), "Addresses successfully located", addressDtos);
        } else {
            return new BaseResponseAddress<>(HttpStatus.NOT_FOUND.value(), "No addresses found for the given CNPJ", null);
        }
    }

    @PutMapping("/address/update")
    public BaseResponseAddress<AddressDto> updateAddress(@RequestParam("id") String id, @RequestBody AddressRequest request){
        AddressModel addressModel = addressService.updateAddress(id, request);
        AddressDto addressDto = AddressMapper.toAddressDto(addressModel);
        return new BaseResponseAddress<>(HttpStatus.OK.value(), "Address update sucessfully", addressDto);
    }

    @PutMapping("/address/updateCPF")
    public BaseResponseAddress<AddressDto> updateAddressCpf(@RequestParam("cpf") String cpf, @RequestBody AddressRequest request){
        Optional<AddressModel> addressUpdate = addressService.updateAddressByUserCpf(cpf, request);
        AddressDto addressDto = AddressMapper.fromAddressModelToAddressDto(addressUpdate);
        return new BaseResponseAddress<>(HttpStatus.OK.value(), "Address update sucessfully", addressDto);
    }

    @PutMapping("/address/updateCNPJ")
    public BaseResponseAddress<AddressDto> updateAddressCnpj(@RequestParam("cnpj") String cnpj, @RequestParam("AddressId") String addressId, @RequestBody AddressRequest request){
        Optional<AddressModel> addressUpdate = addressService.updateAddressByUserCnpj(cnpj, addressId, request);
        AddressDto addressDto = AddressMapper.fromAddressModelToAddressDto(addressUpdate);
        return new BaseResponseAddress<>(HttpStatus.OK.value(), "Address update sucessfully", addressDto);
    }

}
