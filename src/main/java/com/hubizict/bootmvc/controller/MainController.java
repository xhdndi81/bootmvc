package com.hubizict.bootmvc.controller;

import com.hubizict.bootmvc.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
  
    private final UserService userService;

    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String main(Model model) {

        model.addAttribute("list", userService.getUserList());

        model.addAttribute("user", userService.getUser("id1"));

        return "main";
    }
}
