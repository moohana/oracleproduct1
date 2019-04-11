//package com.stackroute.botservice.repository;
//
//import com.stackroute.botservice.domain.QueryAnswer;
//import com.stackroute.botservice.domain.QueryAnsListWithConcept;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class QueryRespositoryTest {
//
//
//    @Autowired
//    private QueryRespository queryRespository;
//    private QueryAnsListWithConcept userQuery;
//    private QueryAnswer queryAnswer;
//
//    @Before
//    public void setUp() {
//        queryAnswer.setId("101");
//
//    }
//
//    @After
//    public void tearDown() {
//
//        queryRespository.deleteAll();
//    }
//
//
//    @Test
//    public void testSaveUser() {
//        queryRespository.save(userQuery);
//        QueryAnsListWithConcept fetchUser = queryRespository.findById(userQuery.getQueryAnswer().getId()).get();
//        Assert.assertEquals("101", fetchUser.getQueryAnswer().getId());
//
//    }
//
//    @Test
//    public void testSaveUserFailure() {
//        QueryAnsListWithConcept testUser = new QueryAnsListWithConcept();
//        queryRespository.save(testUser);
//        QueryAnsListWithConcept fetchUser = queryRespository.findById(userQuery.getQueryAnswer().getId()).get();
//        Assert.assertNotSame(testUser, fetchUser);
//    }
//
//}