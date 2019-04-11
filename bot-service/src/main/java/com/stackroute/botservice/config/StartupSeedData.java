package com.stackroute.botservice.config;

import com.stackroute.botservice.domain.QueryAnsListWithConcept;
import com.stackroute.botservice.domain.QueryAnswer;
import com.stackroute.botservice.service.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Created on : 03/04/2019 by Subhajit Pal (@rahzex) */

/* Seed data from csv file, seeded into mongodb database every time on start up. */

@Component
class StartupSeedData implements ApplicationListener<ContextRefreshedEvent> {

    private QueryServiceImpl queryServiceImpl;

    @Autowired
    public StartupSeedData(QueryServiceImpl queryServiceImpl) {
        this.queryServiceImpl = queryServiceImpl;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        QueryAnsListWithConcept queryAnsListWithConcept = new QueryAnsListWithConcept();
        QueryAnswer queryAnswer = new QueryAnswer();

        String line = "";
        Path filePath = Paths.get("data.csv");
        List<QueryAnsListWithConcept> queryAnsListWithConceptList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath.toUri()).getAbsolutePath())))
        {
            while ((line = br.readLine()) != null) {

                boolean foundConcept = false;

                // use comma as separator
                String[] quesAndAns = line.split(",");

                // getting all concepts with question/answer set
                queryAnsListWithConceptList = queryServiceImpl.getAll();

                for (QueryAnsListWithConcept q : queryAnsListWithConceptList) {
                    // searching for same concept as the current one
                    if (q.getConcept().equals(quesAndAns[1])) {
                        List<QueryAnswer> queryAnswerList = q.getQueryAnswer();

                        // setting data in "QueryAnswer" object
                        queryAnswer.setId(quesAndAns[0]);
                        queryAnswer.setQuestion(quesAndAns[2]);

                        // setting answer
                        StringBuilder answer = new StringBuilder();
                        for (int i = 3; i < quesAndAns.length; i++) {
                            answer.append(quesAndAns[i]);
                        }
                        queryAnswer.setAnswer(answer.toString());

                        // updating the list of question and answer
                        queryAnswerList.add(queryAnswer);

                        // setting data in "QueryAnsListWithConcept" object
                        queryAnsListWithConcept.setId(q.getId());
                        queryAnsListWithConcept.setConcept(q.getConcept());
                        queryAnsListWithConcept.setQueryAnswer(queryAnswerList);

                        foundConcept = true;
                    }
                }
                if (foundConcept == false || queryAnsListWithConceptList.isEmpty()) {
                    // creating new instance of QueryAnsListWithConcept
                    queryAnsListWithConcept = new QueryAnsListWithConcept();

                    List<QueryAnswer> queryAnswerList = new ArrayList<>();

                    // setting data in "QueryAnswer" object
                    queryAnswer.setId(quesAndAns[0]);
                    queryAnswer.setQuestion(quesAndAns[2]);

                    // setting answer
                    StringBuilder answer = new StringBuilder();
                    for (int i = 3; i < quesAndAns.length; i++) {
                        answer.append(quesAndAns[i]);
                    }
                    queryAnswer.setAnswer(answer.toString());

                    // updating the list of question and answer
                    queryAnswerList.add(queryAnswer);

                    // setting data in "QueryAnsListWithConcept" object
                    queryAnsListWithConcept.setConcept(quesAndAns[1]);
                    queryAnsListWithConcept.setQueryAnswer(queryAnswerList);

                }

                // saving initialized object into mongodb
                queryServiceImpl.saveQuery(queryAnsListWithConcept);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
