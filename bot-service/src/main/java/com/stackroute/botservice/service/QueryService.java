package com.stackroute.botservice.service;

import com.stackroute.botservice.domain.QueryAnsListWithConcept;
import org.springframework.stereotype.Service;

@Service
public interface QueryService {
    QueryAnsListWithConcept saveQuery(QueryAnsListWithConcept queryAnsListWithConcept);
    public String getAnswerOfSimilarQuestion(String concept, String question);
    public QueryAnsListWithConcept updateQueryAnswer(String concept,String question,String answer);
}
