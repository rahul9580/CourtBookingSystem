package com.myorg.cbs.controller;

import com.myorg.cbs.ServiceUri;
import com.myorg.cbs.entities.UserEntity;
import com.myorg.cbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(ServiceUri.USER_BASE_URL)
    private List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(ServiceUri.USER_BY_ID_URL)
    private UserEntity getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(ServiceUri.USER_BY_ID_URL)
    private void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @PostMapping(ServiceUri.USER_BASE_URL)
    private int saveUser(@RequestBody UserEntity user) {
        userService.saveOrUpdate(user);
        return user.getUserId();
    }
}
