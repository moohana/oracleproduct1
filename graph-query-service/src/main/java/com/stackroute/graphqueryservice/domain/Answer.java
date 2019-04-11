package com.stackroute.graphqueryservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity(label = "Answer") //This annotation creates the node with label name as Answer
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private String answer;
}
