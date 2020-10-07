package com.hedon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hedon Wang
 * @create 2020-10-05 17:45
 */
@RestController
@RequestMapping("/haha")
public class HahaController {

    @GetMapping("/haha")
    public String haha(){
        return "hhhhhhhh";
    }
}
