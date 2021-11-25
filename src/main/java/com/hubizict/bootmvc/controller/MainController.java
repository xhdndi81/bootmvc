package com.hubizict.bootmvc.controller;

import java.util.Map;

import com.hubizict.bootmvc.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
  
    private final UserService userService;

    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String main(Model model) {

        System.out.println("== main : test");

        model.addAttribute("list", userService.getUserList());

        model.addAttribute("user", userService.getUser("id1"));

        return "main";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)    
    public String update(@RequestBody Map<String, Object> user, Model model) {
        
        userService.updateUser(user);

        model.addAttribute("user", user);
        
        return "jsonView";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("ID") String id) {

        System.out.println("== ID :" + id);

        userService.deleteUser(id);

        return "redirect:/main";
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Map<String, Object> user) {

        userService.insertUser(user);

        return "jsonView";
    }
}
