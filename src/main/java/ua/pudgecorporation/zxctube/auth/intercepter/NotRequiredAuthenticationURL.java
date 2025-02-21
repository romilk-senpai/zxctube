package ua.pudgecorporation.zxctube.auth.intercepter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum NotRequiredAuthenticationURL {
    LOGIN("/api/v1/auth/login"),
    REGISTER("/api/v1/auth/register");

    @Getter
    private final String URL;
}
