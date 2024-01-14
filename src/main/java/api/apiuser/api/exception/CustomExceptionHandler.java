package api.apiuser.api.exception;

import api.apiuser.api.error.BaseResponseError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler implements AuthenticationFailureHandler {

    private ResponseEntity<BaseResponseError> buildErrorResponse(HttpStatus status, String message){
        BaseResponseError response = BaseResponseError.builder()
                .errorCode(status.toString())
                .message(message)
                .build();
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BaseResponseError> badRequestException(BadRequestException ex){
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "The request was not understood by the server.");
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<BaseResponseError> handleUnauthorizedException(UnauthorizedException ex) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Not authorized");
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<BaseResponseError> forbiddenException(ForbiddenException ex){
        return buildErrorResponse(HttpStatus.FORBIDDEN, "The server does not authorize access to the requested resource.");
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<BaseResponseError> notFoundException(NotFoundException ex){
        return buildErrorResponse(HttpStatus.NOT_FOUND, "The requested resource was not found.");
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<BaseResponseError> entityNotFound(EntityNotFoundException ex){
        return buildErrorResponse(HttpStatus.NOT_FOUND, "The requested resource entity was not found.");
    }

    @ExceptionHandler({NotAcceptableException.class})
    public ResponseEntity<BaseResponseError> notAcceptableException(NotAcceptableException ex){
        return buildErrorResponse(HttpStatus.NOT_ACCEPTABLE, "The server cannot return the requested resource in the specified format.");
    }

    @ExceptionHandler({ProxyAuthenticationRequeridException.class})
    public ResponseEntity<BaseResponseError> proxyAuthenticationRequerid(ProxyAuthenticationRequeridException ex){
        return buildErrorResponse(HttpStatus.PROXY_AUTHENTICATION_REQUIRED, "The server requires proxy authentication.");
    }

    @ExceptionHandler({RequestTimeoutException.class})
    public ResponseEntity<BaseResponseError> requestTimeOut(RequestTimeoutException ex){
        return buildErrorResponse(HttpStatus.REQUEST_TIMEOUT, "The request expired before being processed.");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Integer status = HttpStatus.FORBIDDEN.value();
        response.setStatus(status);
        response.setContentType("application/json");

        BaseResponseError baseBobyError = BaseResponseError.builder()
                .errorCode(String.valueOf(status))
                .message("Credenciais Inválida!")
                .build();

        response.getWriter().append(baseBobyError.toJson());
    }
}
