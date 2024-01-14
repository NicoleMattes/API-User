package api.apiuser.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotNull
    @NotBlank
    @Size(min = 8, max = 12)
    @Pattern(regexp = "^[0-9]*$")
    @Schema(description = "Código de Endereçamento Postal", example = "198309432")
    private String cep;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "name of the street", example = "Avenida Vila Olimpia")
    private String publicPlace;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 5)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "residence number ", example = "20B")
    private String number;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "Corporate reason", example = "Adidas")
    private String complement;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 240)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "District", example = "Vila Olimpia")
    private String neighborhood;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 240)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(description = "District", example = "São Paulo")
    private String city;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(example = "SP")
    private String state;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 240)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\W)(?!.*\\\\s).{8,}$\n")
    @Schema(example = "Brasil")
    private String country;

}
