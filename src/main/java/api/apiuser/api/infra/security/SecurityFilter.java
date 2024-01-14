package api.apiuser.api.infra.security;

import api.apiuser.api.exception.BadRequestException;
import api.apiuser.api.exception.CustomExceptionHandler;
import api.apiuser.api.exception.UnauthorizedException;
import api.apiuser.api.repository.UserCnpjRepository;
import api.apiuser.api.repository.UserCpfRepository;
import api.apiuser.api.request.UserLoginRequest;
import api.apiuser.api.utilities.UserType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SecurityFilter extends UsernamePasswordAuthenticationFilter {
    private UserCnpjRepository userCnpjRepository;
    private UserCpfRepository userCpfRepository;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    public SecurityFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserCnpjRepository userCnpjRepository) {
        setAuthenticationFailureHandler(new CustomExceptionHandler());
        this.authenticationManager = authenticationManager;
        this.userCnpjRepository = userCnpjRepository;
        this.jwtUtil = jwtUtil;
    }

    public SecurityFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserCpfRepository userCpfRepository) {
        setAuthenticationFailureHandler(new CustomExceptionHandler());
        this.authenticationManager = authenticationManager;
        this.userCpfRepository = userCpfRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserLoginRequest userLoginRequest = new ObjectMapper().readValue(request.getInputStream(), UserLoginRequest.class);
            if(userLoginRequest.getEmail() == null || userLoginRequest.getPassword() == null || userLoginRequest.getUserType() == null){
                throw new BadRequestException("Requisição Inválida!");
            }

            Object user = null;
            if (userLoginRequest.getUserType() == UserType.CPF) {
                user = userCpfRepository.findByEmail(userLoginRequest.getEmail());
            } else if (userLoginRequest.getUserType() == UserType.CNPJ) {
                user = userCnpjRepository.findByEmail(userLoginRequest.getEmail());
            } else {
                throw new BadRequestException("Tipo de usuário inválido!");
            }

            if(Objects.isNull(user)){
                throw new UnauthorizedException("Credenciais Inválidas!");
            }

            UsernamePasswordAuthenticationToken authToken = buildAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword());
            Authentication authentication = this.authenticationManager.authenticate(authToken);
            return authentication;

        } catch (Exception e){
            throw new UnauthorizedException("Credenciais Inválidas!");
        }
    }

    private UsernamePasswordAuthenticationToken buildAuthenticationToken(String email, String password) {
        return new UsernamePasswordAuthenticationToken(email, password, new ArrayList<>());
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws ServletException, IOException {
        UserDetailsSecurity userDetailsSecurity = (UserDetailsSecurity) authentication.getPrincipal();
        String userName = userDetailsSecurity.getUsername();
        String token = this.jwtUtil.generateToken(userName);
        response.addHeader("Authorization", token);
        response.addHeader("access-control-expose-headers", "Authorization");
    }


}
