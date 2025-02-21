package ua.pudgecorporation.zxctube.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse<BODY> {
    private Boolean success;
    private String token;
    private BODY body;

    public Boolean isSuccess() {
        return success;
    }

    public static AuthResponse ofFail() {
        return new AuthResponse(false, null, null);
    }
}
