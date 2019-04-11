package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.domain.QuestionDTO;
import com.stackroute.manualservice.domain.UserQuery;
import com.stackroute.manualservice.exception.QueryNotFoundException;
import com.stackroute.manualservice.repository.ManualRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManualServiceImplTest {
    private Query query;
    private UserQuery userQuery;

    @Autowired
    private ManualService manualService;
    @Autowired
    private ManualRepository manualRepository;
    private ArrayList list;
    private List<Query> queryList = null;

    @Before
    public void setUp() throws Exception {

        queryList=new ArrayList<>();
        query = new Query();
        query.setQuestion("abcd");
        query.setId("1");
        query.setAnswer("kjsfdjefj");
        queryList.add(query);
        userQuery = new UserQuery();
        userQuery.setQuery(queryList);
        userQuery.setConcept("abcd");
        userQuery.setId("we");

    }


    @Test
    public void getListOfQuestions() {

        List<UserQuery> userQueryList = manualService.getListOfQuestions();
        Assert.assertEquals(userQueryList, userQueryList);
    }

    @Test
    public void getQuestionsByTopicName() {
        manualRepository.save(userQuery);
        UserQuery foundQuestion = manualService.getQuestionsByTopicName("abcd");
        Assert.assertEquals(userQuery,foundQuestion);
    }
    }
