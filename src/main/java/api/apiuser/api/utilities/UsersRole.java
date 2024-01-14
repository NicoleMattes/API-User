package api.apiuser.api.utilities;

import api.apiuser.api.exception.ForbiddenException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
@AllArgsConstructor
@Getter
public enum UsersRole {
    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private Integer code;
    private String description;

    public static UsersRole toEnum(String code){
        if(Objects.isNull(code)){
            return null;
        }

        for (UsersRole x: UsersRole.values()){
            if (code.equals(x.getCode())){
                return x;
            }
        }
        throw new ForbiddenException("Role Inválido: " + code);
    }
}
