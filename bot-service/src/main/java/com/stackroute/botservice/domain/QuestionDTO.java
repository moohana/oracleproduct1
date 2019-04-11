package com.stackroute.botservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    @Id
    private String id;
    private String concept;
    private String question;
    private String answer;
}
