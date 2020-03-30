package com.attractor.laboratory56.model;

import com.attractor.laboratory56.repository.UserRepository;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Document(collection = "tasks")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Task {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    public String headline;
    public String description;
    public String performanceDate;
    @DBRef
    public User user;
    @Getter
    @Setter
    public String status = "new";

    public Task(String headline, String description, String performanceDate, User user) {
        this.id = UUID.randomUUID().toString();
        this.headline = headline;
        this.description = description;
        this.performanceDate = performanceDate;
        this.user = user;
    }

}
