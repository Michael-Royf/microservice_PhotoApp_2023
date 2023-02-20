package com.michael.accountManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @GetMapping("/status/check")
    public ResponseEntity<String> status(){
        return new ResponseEntity<>("Working...", HttpStatus.OK);
    }
}
