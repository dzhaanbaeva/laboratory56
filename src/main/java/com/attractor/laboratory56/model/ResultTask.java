package com.attractor.laboratory56.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Data
@Builder
public class ResultTask {
    @Id
    @Builder.Default
    String id;
    String headline;
    String performanceDate;

    public ResultTask(String id, String headline, String performanceDate) {
        this.id = id;
        this.headline = headline;
        this.performanceDate = performanceDate;
    }
}
