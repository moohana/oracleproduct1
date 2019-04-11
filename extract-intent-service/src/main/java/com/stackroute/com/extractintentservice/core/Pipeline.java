package com.stackroute.com.extractintentservice.core;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class Pipeline {

    @Autowired
    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
    private  static String propertiesName="tokenize, ssplit, pos, lemma";

    private Pipeline()
    {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators",propertiesName);
    }

    @Bean(value = "stanfordCoreNLP")
    public  static StanfordCoreNLP getInstance()
    {
        if(stanfordCoreNLP==null)
        {
            stanfordCoreNLP= new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }

}
