package api.apiuser.api.request;

import api.apiuser.api.repository.model.AddressModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCnpjRequest {

    @NotNull
    @NotBlank
    @Size(min = 11, max = 16)
    @Pattern(regexp = "^[0-9]*$")
    @Schema(description = "Cadastro Nacional de Pessoas Jurídicas", example = "98798793428798")
    private String cnpj;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String userName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "Corporate reason", example = "Adidas")
    private String corporateReason;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "Corporate reason", example = "Adidas")
    private String nameFantasy;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 250)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Schema(description = "email for contact", example = "nicole@gmail.com")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 250)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String branch;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "password for access", example = "1234Nicole@")
    private String password;

    @Schema(description = "address")
    private List<AddressModel> addressList;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(ADMIN|USER)$")
    private String role;


}
