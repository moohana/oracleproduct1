//package com.stackroute.botservice.controller;
//
//import com.stackroute.botservice.domain.QueryAnswer;
//import com.stackroute.botservice.domain.QueryAnsListWithConcept;
//import com.stackroute.botservice.service.QueryServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class BotControllerTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//    private QueryAnsListWithConcept userQuery;
//    @MockBean
//    private QueryServiceImpl queryService;
//    @InjectMocks
//    private BotController botController;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup().build();
//        userQuery = new QueryAnsListWithConcept();
//        QueryAnswer queryAnswer = new QueryAnswer();
//        queryAnswer.setQuestion("this is my question");
////        queryAnswer.setAnswer("this is my answer");
////        Status status = new Status();
////        status.setAnswered(true);
////        status.setAccepted(true);
////        userQuery.setQueryAnswer(queryAnswer);
////        userQuery.setStatus(status);
//
//    }
//
//    @Test
//    public void sendNewQueryTest() throws Exception {
//        when(queryService.saveQuery(any())).thenReturn(userQuery);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/send/queryAnswer")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userQuery)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}