package api.apiuser.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class BaseResponseAddress <AddressDto> {
    private Integer httpCode;
    private String message;
    private AddressDto response;
}


