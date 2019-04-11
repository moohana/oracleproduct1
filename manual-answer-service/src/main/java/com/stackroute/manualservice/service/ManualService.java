package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.domain.QuestionDTO;
import com.stackroute.manualservice.domain.UserQuery;
import com.stackroute.manualservice.exception.QueryAlreadyExistException;
import com.stackroute.manualservice.exception.QueryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManualService {

    //Save user
    public UserQuery saveToDataBase(QuestionDTO questionDTO);

    //get List of Question
    public List<UserQuery> getListOfQuestions();


    //Update Query
    public UserQuery updateQuestion(Query query,String concept) throws QueryNotFoundException;

    //Delete Query
    public UserQuery deleteQuestion(Query query,String concept) throws QueryNotFoundException;


    //Get Query by Topic name

    public UserQuery getQuestionsByTopicName(String name);
}
