package api.apiuser.api.exception;

public class InternalServiserErrorException extends RuntimeException{
    public InternalServiserErrorException(String message){
        super(message);
    }
}
