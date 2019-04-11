package com.stackroute.botservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendQuery {

    private QueryAnswer queryAnswer;
    private Status status;

}
