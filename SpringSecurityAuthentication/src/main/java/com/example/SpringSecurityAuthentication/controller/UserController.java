package com.example.SpringSecurityAuthentication.controller;

import com.example.SpringSecurityAuthentication.model.UserModel;
import com.example.SpringSecurityAuthentication.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody UserModel userModel) {
        if (userModel == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username and Password are required");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userModel));

    }
}
