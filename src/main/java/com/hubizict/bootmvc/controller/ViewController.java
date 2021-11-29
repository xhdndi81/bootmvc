package com.hubizict.bootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {    
    
    @RequestMapping(value="viewUser", method = RequestMethod.GET)
    public String viewUser() {
        return "user";
    }

}
