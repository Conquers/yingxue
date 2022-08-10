package com.cqupt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kioo
 */
@RestController
@RequestMapping("demos")
public class DemoController {

    @GetMapping
    public String demos(){
        return "category demos";
    }
}
