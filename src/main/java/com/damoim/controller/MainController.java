package com.damoim.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {


    @GetMapping({"", "/"})
    public String main(){
        return "index";
    }


}
