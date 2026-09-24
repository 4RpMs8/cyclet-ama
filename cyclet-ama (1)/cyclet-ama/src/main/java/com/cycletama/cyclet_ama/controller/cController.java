package com.cycletama.cyclet_ama.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello CYCLET AMA";
    }
}
