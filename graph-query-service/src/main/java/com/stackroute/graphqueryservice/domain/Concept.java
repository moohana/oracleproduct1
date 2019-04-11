package com.stackroute.graphqueryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Concept") //This annotation creates the node with label name as Concept
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Concept {

    @Id
    @GeneratedValue
    private Long graphId;
    private String name;

}