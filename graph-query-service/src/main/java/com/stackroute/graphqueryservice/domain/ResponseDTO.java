package com.stackroute.graphqueryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@QueryResult
public class ResponseDTO {
    List<Response> responses;
}
