package com.stackroute.manualservice.repository;


import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.domain.UserQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManualRepository extends MongoRepository<UserQuery,String> {

    @org.springframework.data.mongodb.repository.Query("{ 'concept' : ?0 }")
    UserQuery searchByTopicName(String name);

}
