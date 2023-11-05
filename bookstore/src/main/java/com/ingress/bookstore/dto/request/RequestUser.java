package com.ingress.bookstore.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ingress.bookstore.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class RequestUser {
    private String username;
    private String password;
    private UserRole role;
}
