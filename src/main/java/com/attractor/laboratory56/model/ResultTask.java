package com.attractor.laboratory56.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document
@Data
@Builder
public class ResultTask {
    @Id
    @Builder.Default
    String id;
    String headline;
    LocalDate performanceDate;

    public ResultTask(String id, String headline, LocalDate performanceDate) {
        this.id = id;
        this.headline = headline;
        this.performanceDate = performanceDate;
    }
}
