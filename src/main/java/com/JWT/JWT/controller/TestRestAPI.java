package com.JWT.JWT.controller;

import com.JWT.JWT.security.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * TestRestAPI.
 */
@RestController
public class TestRestAPI {

    @Autowired
    JWT jwtCreator;


    @GetMapping("/")
    public String hello() throws UnsupportedEncodingException {

        return jwtCreator.createToken();
    }

    @PostMapping("/")
    public String checkToken(@RequestBody String token){



        return jwtCreator.checkToken(token);
    }
}
