package com.example.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    // database

    @GetMapping("/get_users")
    public ResponseEntity<List<User>> getUsers(){

        return new ResponseEntity(userService.getAllUsers(),HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_user_body")
    public ResponseEntity addUserBody(@RequestBody(required = true)User u)
    {
        userService.addUserToDB(u);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}