package com.example.demo.controller;

import com.example.demo.dto.UrlRegistrationRequestDto;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @PostMapping("/register.json")
    public ResponseEntity<Map<String, Object>> registerByUrl(UrlRegistrationRequestDto requestDto) {
        return new ResponseEntity<>(userService.saveUrlAndReturnId(requestDto), HttpStatus.CREATED);
    }
}
