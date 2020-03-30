package com.attractor.laboratory56.dto;

import com.attractor.laboratory56.model.User;
import lombok.*;

import java.util.UUID;
@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {

        public static UserDTO from(User user) {
            return builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();
        }



        private String id = UUID.randomUUID().toString();
        public String username;
        public String email;
        public String password;

    }



