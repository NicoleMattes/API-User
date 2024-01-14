package api.apiuser.api.exception;

public class RequestTimeoutException extends RuntimeException{
    public RequestTimeoutException(String message){
        super(message);
    }
}
