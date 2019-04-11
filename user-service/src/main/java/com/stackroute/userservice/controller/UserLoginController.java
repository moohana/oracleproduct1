package com.stackroute.userservice.controller;


import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserLoginController {

    @Autowired
    private UserService userService;

    /*It will display all the users and admins*/
    @GetMapping(value = "/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers()
    {
            List<User> users= userService.findall();
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    /*It will display only the users*/
    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(Principal principal)
    {
      User user1= userService.getUserByEmail(principal.getName());
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }
}
