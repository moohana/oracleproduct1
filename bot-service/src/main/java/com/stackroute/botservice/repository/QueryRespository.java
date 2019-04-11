package com.stackroute.botservice.repository;


import com.stackroute.botservice.domain.QueryAnsListWithConcept;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QueryRespository extends MongoRepository<QueryAnsListWithConcept, String> {
}
