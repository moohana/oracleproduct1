package com.stackroute.graphqueryservice.repository;

import com.stackroute.graphqueryservice.domain.Questions;
import com.stackroute.graphqueryservice.domain.Response;
import com.stackroute.graphqueryservice.domain.ResponseDTO;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends Neo4jRepository<Questions, Long> {


    /*
     Displays the set of questions and corresponding answers for that questions
     */
    @Query("MATCH (concept:Concept{name:({concept})})<-[:QUESTION_OF]-(question:Questions)<-[:ANSWER_OF]-(answer:Answer) RETURN collect(({question:question.name,answer:answer.answer})) as responses")
    ResponseDTO findByConcept(String concept);

    /*
        creates nodes for question and answer and also creates relationships
        between concept,question and answer
     */

    @Query("MATCH (c:Concept) where c.name=({concept}) \n" +
            "CREATE (a:Answer {answer:({answer}),concept:({concept})} )\n" +
            "CREATE (q:Questions {name:({question}),concept:({concept})} )\n" +
            "CREATE (a)-[r1:ANSWER_OF]->(q) \n" +
            "CREATE (q)-[r2:QUESTION_OF]->(c) return r1,r2,a,q,c")
    List<Questions> createNodesAndRelationships(String concept, String question, String answer);

}
