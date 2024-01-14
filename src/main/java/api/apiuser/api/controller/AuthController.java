package api.apiuser.api.controller;

import api.apiuser.api.dto.UserTokenDto;
import api.apiuser.api.infra.security.JWTUtil;
import api.apiuser.api.request.UserLoginRequest;
import api.apiuser.api.service.AuthService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final JWTUtil jwtUtil;
    private final AuthService authService;

    @PostMapping("/loginCnpj")
    public UserTokenDto loginCnpj(@RequestBody UserLoginRequest request) {
        UserTokenDto userTokenDto = authService.loginCnpj(request);
        return userTokenDto;
    }

    @PostMapping("/loginCpf")
    public UserTokenDto loginCpf(@RequestBody UserLoginRequest request){
        UserTokenDto userTokenDto = authService.loginCpf(request);
        return userTokenDto;
    }
}
