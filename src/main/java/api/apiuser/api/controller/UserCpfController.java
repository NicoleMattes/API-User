package api.apiuser.api.controller;

import api.apiuser.api.dto.UserCpfDto;
import api.apiuser.api.exception.BadRequestException;
import api.apiuser.api.mapper.UserCpfMapper;
import api.apiuser.api.repository.model.UserCpfModel;
import api.apiuser.api.request.UserCpfRequest;
import api.apiuser.api.response.BaseResponseUserCpf;
import api.apiuser.api.service.UserCpfService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/cpf-gx/auth")
public class UserCpfController {
    @Autowired
    private final UserCpfService userCpfService;

    @PostMapping("/register")
    public BaseResponseUserCpf<UserCpfDto> newUserCpf(@RequestBody UserCpfRequest request) throws BadRequestException, EntityNotFoundException {
        UserCpfModel userCpfModel = userCpfService.createdNewUser(request);
        UserCpfDto userCpfDto = UserCpfDto.fromUserCpfModel(userCpfModel);
        return new BaseResponseUserCpf<>(HttpStatus.OK.value(), "user created successfully", userCpfDto);
    }

    @GetMapping("/user")
    public BaseResponseUserCpf<UserCpfDto> getUserCpf(@RequestParam("id") String id){
        UserCpfModel userCpfModel = userCpfService.getUserCpf(id);
        UserCpfDto userCpfDto = UserCpfDto.fromUserCpfModel(userCpfModel);
        return new BaseResponseUserCpf<>(HttpStatus.OK.value(), "user found successfully", userCpfDto);
    }

    @PutMapping("/user/update")
    public BaseResponseUserCpf<UserCpfDto> updateUserCpf(@RequestParam("id") String id, @RequestBody UserCpfRequest request){
        UserCpfModel userCpfModel = userCpfService.updateUserCpf(id, request);
        UserCpfDto userCpfDto = UserCpfMapper.toUserDto(userCpfModel);
        return new BaseResponseUserCpf<>(HttpStatus.OK.value(), "user updated successfully", userCpfDto);
    }


    @DeleteMapping("/user/delete/")
    public BaseResponseUserCpf<Void> deleteUser(@RequestParam("id") String id){
        userCpfService.deleteUserCnpj(id);
        return new BaseResponseUserCpf<>(HttpStatus.OK.value(), "user deleted successfully", null);
    }
}
