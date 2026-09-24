package com.cycletama.cyclet_ama.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public string hello(){
        return "hello CycletAma";
    }
}
