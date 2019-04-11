package com.stackroute.botservice.service;

import com.stackroute.botservice.domain.QueryAnsListWithConcept;
import com.stackroute.botservice.domain.QueryAnswer;
import com.stackroute.botservice.repository.QueryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

import org.apache.commons.text.similarity.LevenshteinDistance;

@Service
public class QueryServiceImpl implements QueryService {


    private QueryRespository queryRespository;

    @Autowired
    public QueryServiceImpl(QueryRespository queryRespository) {
        this.queryRespository = queryRespository;
    }

    //this method add queryAnswer to mongo database
    @Override
    public QueryAnsListWithConcept saveQuery(QueryAnsListWithConcept queryAnsListWithConcept) {
        return queryRespository.save(queryAnsListWithConcept);
    }

    public List<QueryAnsListWithConcept> getAll() {
        return queryRespository.findAll();
    }



    /* This method finds all similar questions and their answers according
     * to concept. Only the question with levenshtien distance <=2 is
     * considered to be a similar question. If not <=2 then a null string
     * will be returned.
     * Written on : 03/08/2019 by Subhajit Pal (@rahzex) */

    @Override
    public String getAnswerOfSimilarQuestion(String concept, String question) {
        TreeMap<Integer, String> distanceWithAnswerMap = new TreeMap<>();

        /* getting all concepts with question and answer list */
        List<QueryAnsListWithConcept> queryAnsListWithConceptList = queryRespository.findAll();

        for (QueryAnsListWithConcept q : queryAnsListWithConceptList) {

            /* searching for same concept as the current one */
            if (q.getConcept().equals(concept)) {

                /* getting all questions with answer as a list from current concept */
                List<QueryAnswer> queryAnswerList = q.getQueryAnswer();

                /* finding similar question from question answer list
                 * by using Levenshtein-Distance algorithm */
                LevenshteinDistance getDistance = new LevenshteinDistance();
                for (QueryAnswer qa : queryAnswerList)
                    distanceWithAnswerMap.put(getDistance.apply(question, qa.getQuestion()), qa.getAnswer());
            }
        }

        String answer = null;
        // initialize answer if and only if the distance is less than 2
        if (!distanceWithAnswerMap.isEmpty()){
            if (distanceWithAnswerMap.firstKey() <= 2 ) {
                answer = distanceWithAnswerMap.get(distanceWithAnswerMap.firstKey());
            }
        }


        return answer;

    }
    @Override
    public QueryAnsListWithConcept updateQueryAnswer(String concept,String question,String answer) {
        QueryAnsListWithConcept queryAnsListWithConcept = new QueryAnsListWithConcept();
        // getting all concepts with question/answer set
        List<QueryAnsListWithConcept> queryAnsListWithConceptList = queryRespository.findAll();

        for (QueryAnsListWithConcept q : queryAnsListWithConceptList) {
            // searching for same concept as the current one
            if (q.getConcept().equals(concept)) {
                List<QueryAnswer> queryAnswerList = q.getQueryAnswer();
                QueryAnswer qa = new QueryAnswer();
                qa.setQuestion(question);
                qa.setAnswer(answer);

                queryAnswerList.add(qa);

                // setting data in "QueryAnsListWithConcept" object
                queryAnsListWithConcept.setId(q.getId());
                queryAnsListWithConcept.setConcept(q.getConcept());
                queryAnsListWithConcept.setQueryAnswer(queryAnswerList);
            }
        }

        queryRespository.save(queryAnsListWithConcept);

        return queryAnsListWithConcept;
    }


}
