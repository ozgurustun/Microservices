package org.ebuy.authservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Document(collection = "passwordResetToken")
public class PasswordResetToken {

    @Id
    private String id;

    private String generatedPasswordResetToken;

    private User user;

    private LocalDateTime createdAt;

    public PasswordResetToken(User user) {
        this.user = user;
        createdAt = LocalDateTime.now();
        generatedPasswordResetToken = UUID.randomUUID().toString();
    }


    public PasswordResetToken(String id, String generatedPasswordResetToken, User user, LocalDateTime createdAt) {
        this.id = id;
        this.generatedPasswordResetToken = generatedPasswordResetToken;
        this.user = user;
        this.createdAt = createdAt;
    }

    @PersistenceConstructor
    public PasswordResetToken() {
    }
}