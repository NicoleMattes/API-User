package api.apiuser.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenDto {
    private String userName;
    private String token;
    private String role;
    private String type;
}
