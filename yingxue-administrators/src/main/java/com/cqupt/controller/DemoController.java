package com.cqupt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kioo
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(){
        throw new RuntimeException("xxx");
    }
}
