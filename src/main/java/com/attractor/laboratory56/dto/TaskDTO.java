package com.attractor.laboratory56.dto;

import com.attractor.laboratory56.model.Task;
import com.attractor.laboratory56.model.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class TaskDTO {
    public static TaskDTO from(Task task) {

        return builder()
                .id(task.getId())
                .headline(task.getHeadline())
                .description(task.getDescription())
                .performanceDate(task.getPerformanceDate())
                .userId(task.getUser().getId())
                .status(task.getStatus())
                .build();

    }

    private String id = UUID.randomUUID().toString();
    public  String headline;
    public  String description;
    public String performanceDate;
    public String userId;
    public  String status;



}
