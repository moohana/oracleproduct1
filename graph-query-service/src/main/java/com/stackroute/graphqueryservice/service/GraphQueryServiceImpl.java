package com.stackroute.graphqueryservice.service;

import com.stackroute.graphqueryservice.domain.Concept;
import com.stackroute.graphqueryservice.domain.Questions;
import com.stackroute.graphqueryservice.domain.Response;
import com.stackroute.graphqueryservice.domain.ResponseDTO;
import com.stackroute.graphqueryservice.repository.ConceptRepository;
import com.stackroute.graphqueryservice.repository.QueryRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class GraphQueryServiceImpl implements GraphQueryService {
    private QueryRepository queryRepository;
    private ConceptRepository conceptRepository;

    @Autowired
    public GraphQueryServiceImpl(QueryRepository queryRepository, ConceptRepository conceptRepository) {
        this.queryRepository = queryRepository;
        this.conceptRepository = conceptRepository;
    }

    /*
      This method takes concept and question through rest call and
      returns the set of answers for that particular question and concept
     */
    @Override
    public ResponseDTO solution(String concept) {
        return queryRepository.findByConcept(concept);
    }

    /*
        This method takes concept,question and answer through rest call and
        creates question and answer domain and also creates relationship between them,
        and also this entire set is attached to particular concept
     */
    @Override
    public List<Questions> createNodesAndRelationships(String concept, String question, String answer) {
        return queryRepository.createNodesAndRelationships(concept, question, answer);
    }

    /*
        This method displays all the concepts
     */
    @Override
    public Iterable<Concept> concepts() {
        return conceptRepository.findAll();
    }

}