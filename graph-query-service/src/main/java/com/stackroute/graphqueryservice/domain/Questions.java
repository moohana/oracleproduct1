package com.stackroute.graphqueryservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.QueryResult;


@NodeEntity(label = "Questions") //This annotation creates the node with label name as Questions
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
    private String name;

    /*
        This annotation creates the relationship as ANSWER_OF
        between the Questions node and Answer node.It also mentions
        the direction of relationship as INCOMING

     */
  /*  @Relationship(type = "ANSWER_OF", direction = "INCOMING")
    private List<Answer> answerList;*/

}