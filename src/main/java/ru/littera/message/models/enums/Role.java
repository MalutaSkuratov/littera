package ru.littera.message.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() { // Переделовает роль в строковое представление
        return name();
    }
}
