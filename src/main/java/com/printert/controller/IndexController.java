package com.printert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }
    @RequestMapping({"/home"})
    public String home(){
        return "home";
    }
}
