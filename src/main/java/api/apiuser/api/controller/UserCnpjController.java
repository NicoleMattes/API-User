package api.apiuser.api.controller;

import api.apiuser.api.dto.UserCnpjDto;
import api.apiuser.api.exception.BadRequestException;
import api.apiuser.api.mapper.UserCnpjMapper;
import api.apiuser.api.repository.model.UserCnpjModel;
import api.apiuser.api.request.UserCnpjRequest;
import api.apiuser.api.response.BaseResponseUserCnpj;
import api.apiuser.api.service.UserCnpjService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/cnpj-gx/auth")
public class UserCnpjController {

    @Autowired
    private final UserCnpjService userCnpjService;

    @PostMapping("/register")
    public BaseResponseUserCnpj<UserCnpjDto> newUserCnpj(@RequestBody UserCnpjRequest request) throws BadRequestException, EntityNotFoundException{
        UserCnpjModel userCnpjModel = userCnpjService.createdNewUser(request);
        UserCnpjDto userCnpjDto = UserCnpjDto.fromUserCnpjModel(userCnpjModel);
        return new BaseResponseUserCnpj<>(HttpStatus.OK.value(), "user created successfull", userCnpjDto);
    }

    @GetMapping("/user")
    public BaseResponseUserCnpj<UserCnpjDto> getUserCnpj(@RequestParam("id") String id){
        UserCnpjModel userCnpjModel = userCnpjService.getUserCnpj(id);
        UserCnpjDto userCnpjDto = UserCnpjDto.fromUserCnpjModel(userCnpjModel);
        return new BaseResponseUserCnpj<>(HttpStatus.OK.value(), "User found successfully", userCnpjDto);
    }

    @PutMapping("/user/update")
    public BaseResponseUserCnpj<UserCnpjDto> updateUserCnpj(@RequestParam("id") String id, @RequestBody UserCnpjRequest request){
        UserCnpjModel userCnpjModel = userCnpjService.updateUserCnpj(id, request);
        UserCnpjDto userCnpjDto = UserCnpjMapper.toUserCnpjDto(userCnpjModel);
        return new BaseResponseUserCnpj<>(HttpStatus.OK.value(), "user updated successfully", userCnpjDto);
    }

    @DeleteMapping("/user/delete")
    public BaseResponseUserCnpj<Void> deletarUser(@RequestParam("id") String id){
        userCnpjService.deleteUserCnpj(id);
        return new BaseResponseUserCnpj<>(HttpStatus.OK.value(), "User deletd successfully", null);
    }
}
