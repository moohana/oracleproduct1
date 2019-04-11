package com.stackroute.queryautocorrector.controller;

import com.stackroute.queryautocorrector.corrector.QueryAutoCorrector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class QueryCorrectorController {

    @GetMapping("/getCorrectedQuery/{queryAnswer}")
    public String getCorrectedQuery(@PathVariable("queryAnswer") String query) throws IOException {
        String correctedQuery = QueryAutoCorrector.correctQuery(query);
        return correctedQuery;
    }
}
