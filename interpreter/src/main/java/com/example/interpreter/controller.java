package com.example.interpreter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class controller {

    @RequestMapping("/hello")
    public String getMainPage() {
        return "hello";
    }
}
