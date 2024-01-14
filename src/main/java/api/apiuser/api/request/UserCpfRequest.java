package api.apiuser.api.request;

import api.apiuser.api.repository.model.AddressModel;
import api.apiuser.api.utilities.UsersRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCpfRequest {

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]*$")
    @Schema(description = "Cadastro de Pessoas Físicas", example = "98798798798")
    private String cpf;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 250)
    @Pattern(regexp = "[\\p{L}\\p{N}]")
    @Schema(description = "Full name", example = "Lucas Canno")
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 250)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Schema(description = "Full name", example = "Lucas Canno")
    private String userName;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 250)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Schema(description = "email for contact", example = "nicole@gmail.com")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "password for access", example = "1234Nicole@")
    private String password;

    @Schema(description = "address")
    private AddressModel address;

    private String role;



}
