package com.stackroute.graphqueryservice.controller;


import com.stackroute.graphqueryservice.domain.*;
import com.stackroute.graphqueryservice.service.GraphQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GraphQueryController {

    private GraphQueryService graphQueryService;

    private Questions question;
    private Answer answer;

    @Autowired
    public GraphQueryController(GraphQueryService graphQueryService) {
        this.graphQueryService = graphQueryService;
    }

    /*
        This method displays all the concepts
     */
    @GetMapping("/concepts")
    public ResponseEntity<Iterable<Concept>> getConcepts() {
        return new ResponseEntity<>(graphQueryService.concepts(), HttpStatus.OK);
    }

    /*
        This method takes concept and question through rest call and
        returns the set of answers for that particular question and concept
     */
    @GetMapping("/answer/{concept}")
    public ResponseEntity<ResponseDTO> getSolution(@PathVariable String concept) {
        return new ResponseEntity<>(graphQueryService.solution(concept), HttpStatus.FOUND);
    }

    /*
       This method takes concept,question and answer through rest call and
       creates question and answer domain and also creates relationship between them,
       and also this entire set is attached to particular concept
    */
    @PostMapping("/relationship/{concept}/{question}/{answer}")
    public ResponseEntity<List<Questions>> createNodesAndRelationships(@PathVariable String concept, @PathVariable String question, @PathVariable String answer) {
        return new ResponseEntity<>(graphQueryService.createNodesAndRelationships(concept, question, answer), HttpStatus.CREATED);
    }
}