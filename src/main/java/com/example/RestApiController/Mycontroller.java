package com.example.RestApiController;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//we are building CRUD operations API's

@RestController
public class Mycontroller {
    //we are not using database for now so we are writing this Integer as primary key of users database
    Map<Integer, User> users = new HashMap<>();

    //This is get API means listing all the users
    //read operation in crud
    //annotation to get the users is getmapping and inside it u should give endpoint (call)
    @GetMapping("/get_users")
    //getUsers is the function and "get_users" is the endpoint
    //return a list of users so List<user>
    public List<User> getUsers()
    {
        //it has info of all the users to return it
        List<User> listOfUsers = new ArrayList<>();
        //looping through the hashmap we need to return the users so we need to get values of them so users.values
        for(User user : users.values())
        {
            //adding it to the arraylist created to return at the end
            listOfUsers.add(user);
        }
        return listOfUsers;
    }

    //put API means updating
    //parameter which u r sending in url to create a resources
    //create a post api to add the user
    @PostMapping("/add_user")
    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("country") String country)
    {
        //to capture parameter at backend we give parameters
        //name of api? parameter & -> to add nest parameter
        //create a user object for user information and adding it to hashmap
        User user = new User(id,name,age,country);
        users.put(id,user);
    }

    @PostMapping("/add_user_body")
    public void adduserBody(@RequestBody(required=true)User u)
    {
        users.put(u.getId(),u);
    }

    @GetMapping("/get_user/{id}")
    public User getUser(@PathVariable int id)
    {
        return users.get(id);
    }

    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable("id") int index)
    {
        users.remove(index);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody() User user)
    {
        //inorder to update we need some details that needs to be updated for that we are using requestbody
        users.put(id,user);
    }
}
