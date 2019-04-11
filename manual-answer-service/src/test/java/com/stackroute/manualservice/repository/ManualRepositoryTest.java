package com.stackroute.manualservice.repository;

import com.netflix.discovery.converters.Auto;
import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.domain.UserQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManualRepositoryTest {

    @Autowired
    private ManualRepository manualRepository;

    private List<Query> queryList = null;
    private UserQuery userQuery;

    private Query query;

    @Before
    public void setUp(){
        queryList=new ArrayList<>();
        query = new Query();
        query.setQuestion("abcd");
        query.setId("1");
        query.setAnswer("kjsfdjefj");
        queryList.add(query);
        userQuery = new UserQuery();
        userQuery.setQuery(queryList);
        userQuery.setConcept("concept");
        userQuery.setId("we");
    }


    @Test
    public void saveQuerySuccess(){

       UserQuery savedQuery = manualRepository.save(userQuery);
       Assert.assertNotNull(savedQuery);

    }
    @Test
    public void saveQueryFailure(){

        UserQuery savedQuery =  manualRepository.save(userQuery);
        Assert.assertTrue(savedQuery != null);
       // Assert.assertNotEquals("question",savedQuery.getAnswer());
    }

}
