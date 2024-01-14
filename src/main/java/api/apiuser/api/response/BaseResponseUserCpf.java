package api.apiuser.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseUserCpf<UserCpfDto> {
    private Integer httpCode;
    private String message;
    private UserCpfDto response;
}
