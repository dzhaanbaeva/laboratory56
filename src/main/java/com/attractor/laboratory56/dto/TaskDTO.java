package com.attractor.laboratory56.dto;

import com.attractor.laboratory56.model.Task;
import lombok.*;
import java.time.LocalDate;
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
                .performanceDate(LocalDate.now())
                .userId(task.getUser().getId())
                .status(task.getStatus())
                .build();

    }

    private String id = UUID.randomUUID().toString();
    public  String headline;
    public  String description;
    public LocalDate performanceDate;
    public String userId;
    public  String status;



}
