package com.stackroute.queryautocorrector;

import com.stackroute.queryautocorrector.corrector.QueryAutoCorrector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class QueryAutoCorrectorApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(QueryAutoCorrectorApplication.class, args);
	}

}
