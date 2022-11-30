package com.anton.stockexchanger.controller;

import com.anton.stockexchanger.Service.UserService;
import com.anton.stockexchanger.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;


    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDto user) throws Exception {

        try {
           return ResponseEntity.ok().body(userService.addUser(user));
        }catch (Exception e){

            return  ResponseEntity.badRequest().body("User dont added");
        }

    }
}
