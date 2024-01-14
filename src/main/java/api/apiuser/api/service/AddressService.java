package api.apiuser.api.service;

import api.apiuser.api.mapper.AddressMapper;
import api.apiuser.api.repository.AddressRepository;
import api.apiuser.api.repository.UserCnpjRepository;
import api.apiuser.api.repository.UserCpfRepository;
import api.apiuser.api.repository.model.AddressModel;
import api.apiuser.api.repository.model.UserCnpjModel;
import api.apiuser.api.repository.model.UserCpfModel;
import api.apiuser.api.request.AddressRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private final UserCpfRepository userCpfRepository;

    @Autowired
    private final UserCnpjRepository userCnpjRepository;

    public AddressModel newAddress(AddressRequest request) {
        AddressModel addressModel = AddressMapper.toAddressModel(request);
        addressModel = addressRepository.save(addressModel);
        return addressModel;
    }


    public Optional<AddressModel> findAddressByUserCpf(String cpf) {
        // Consulta a tabela `user_cpf` para encontrar o ID do endereço do usuário
        UserCpfModel userCpf = userCpfRepository.findByCpf(cpf);

        // Se o usuário for encontrado, consulta a tabela `address` para encontrar o endereço
        if (userCpf != null) {
            return addressRepository.findById(userCpf.getAddress().getId());
        }

        // Se o usuário não for encontrado, retorna `null`
        return Optional.empty();
    }

    public Optional<List<AddressModel>> findAddressByUserCnpj(String cnpj) {
        UserCnpjModel userCnpj = userCnpjRepository.findByCnpj(cnpj);

        if (userCnpj != null) {
            List<AddressModel> addresses = userCnpj.getAddressList();
            return Optional.of(addresses);
        }
        return Optional.empty();
    }


    private AddressModel updateAddressFields(AddressModel address, AddressRequest request) {
        address.setCep(request.getCep());
        address.setCity(request.getCity());
        address.setComplement(request.getComplement());
        address.setCountry(request.getCountry());
        address.setNeighborhood(request.getNeighborhood());
        address.setPublicPlace(request.getPublicPlace());
        address.setNumber(request.getNumber());
        address.setState(request.getState());

        return addressRepository.save(address);
    }

    public AddressModel updateAddress(String id, AddressRequest request) throws EntityNotFoundException {
        AddressModel address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found " + id));

        AddressModel updateAddress = new AddressModel();
        if (address != null) {
            updateAddress = updateAddressFields(address, request);
        }

        return updateAddress;
    }

    public Optional<AddressModel> updateAddressByUserCpf(String cpf, AddressRequest request) {
        Optional<AddressModel> existingAddressOptional = findAddressByUserCpf(cpf);

        if (existingAddressOptional.isPresent()) {
            AddressModel existingAddress = existingAddressOptional.get();

            // Chama o método updateAddressFields para atualizar os campos do endereço existente
            existingAddress = updateAddressFields(existingAddress, request);

            return Optional.of(existingAddress);
        }
        // Se o endereço atual não for encontrado, retorna Optional.empty()
        return Optional.empty();
    }


    public AddressModel findAddressById(List<AddressModel> addressList, String addressId) {
        return addressList.stream()
                .filter(address -> address.getId().equals(addressId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Address not found " + addressId));
    }

    public Optional<AddressModel> updateAddressByUserCnpj(String cnpj, String addressId, AddressRequest request) {
        Optional<List<AddressModel>> addressListOptional = findAddressByUserCnpj(cnpj);

        if (addressListOptional.isPresent()) {
            AddressModel addressToUpdate = findAddressById(addressListOptional.get(), addressId);

            // Chama o método updateAddressFields para atualizar os campos do endereço
            addressToUpdate = updateAddressFields(addressToUpdate, request);

            return Optional.of(addressToUpdate);
        }

        return Optional.empty();
    }
}


