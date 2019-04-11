package com.stackroute.graphqueryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.annotation.QueryResult;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String question;
    private String answer;


}
