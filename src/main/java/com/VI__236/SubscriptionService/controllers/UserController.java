package com.VI__236.SubscriptionService.controllers;

import com.VI__236.SubscriptionService.models.UserModel;
import com.VI__236.SubscriptionService.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public UserModel createUser(@RequestBody UserModel newUserModel){
        return userService.createUser(newUserModel);
    }

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel updatedUserModel){
        return userService.updateUser(updatedUserModel);
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
    }
}
