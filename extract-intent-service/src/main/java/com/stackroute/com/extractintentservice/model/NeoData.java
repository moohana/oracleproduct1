package com.stackroute.com.extractintentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NeoData {

    private  String Neoconcept;

    public String getNeoconcept() {
        return Neoconcept;
    }

    public void setNeoconcept(String neoconcept) {
        Neoconcept = neoconcept;
    }
}
