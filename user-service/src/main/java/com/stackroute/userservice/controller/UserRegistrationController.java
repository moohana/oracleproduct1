package com.stackroute.userservice.controller;


import com.stackroute.userservice.domain.Response;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> registration(@RequestBody User user)
    {
        user.setRole("USER");
        if (userService.getUserByEmail(user.getEmail())==null) {
            User dbUser = userService.save(user);
            return new ResponseEntity<Response>(new Response(dbUser.getEmail()+" is registered successfully."), HttpStatus.OK);
        }else {
            return new ResponseEntity<Response>(new Response("this email is already registered."), HttpStatus.CONFLICT);
        }
    }
}
