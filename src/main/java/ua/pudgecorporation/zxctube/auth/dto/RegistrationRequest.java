package ua.pudgecorporation.zxctube.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @Schema(description = "user email")
    private String email;
    private String password;
    private String confirmPassword;
}
