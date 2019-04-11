package com.stackroute.manualservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


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
