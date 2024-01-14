package api.apiuser.api.error;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseError {
    private String errorCode;
    private String message;

    public String toJson() {
        return "(\"status\": " + getErrorCode() + ", " +
                "\"message\": \"" + getMessage() + "\")";
    }
}
