package com.example.demo.controller;

import com.example.demo.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private MyBean bean;
    @RequestMapping(value = "/at",method = RequestMethod.GET)
    public String getSth(){
        System.out.println( bean.getName());
        return  "";
    }

}
