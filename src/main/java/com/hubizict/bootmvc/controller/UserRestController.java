package com.hubizict.bootmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hubizict.bootmvc.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grid")
public class UserRestController {
    
    final UserService userService;

    @GetMapping("/user")
    public Map<String, Object> getAllUserList(@RequestParam Map<String, Object> param) {

        Map<String, Object> result = new HashMap<String, Object>();

        Map<String, Object> data = new HashMap<String, Object>();
        List<Map<String, Object>> contents = userService.getUserList();
        data.put("contents", contents);

        result.put("result", true);
        result.put("data", data);

        return result;
    }

    @PutMapping("/modifyUser")
    public void modifyUserData(@RequestBody Map<String, Object> param) {
        System.out.println("== modifyUser : " + param);
    }

    @PutMapping("/user")
    @SuppressWarnings("unchecked") 
    public void updateUserData(@RequestBody Map<String, Object> param) {

        System.out.println("== param : " + param);

        List<Map<String, Object>> updateList = (List<Map<String, Object>>)param.get("updatedRows");

        for(Map<String, Object> user : updateList) {
            userService.updateUser(user);
        }

    }

    @DeleteMapping("/user")
    public void deleteUserData(@RequestParam Map<String, Object> param) {
        
        System.out.println("== param : " + param);
        System.out.println("== param size : " + param.size());

        // List<Map<String, Object>> deleteList = (List<Map<String, Object>>)param.get("deletedRows");

        // System.out.println("== deleteList : " + deleteList);

        // for(Map<String, Object> user : deleteList) {
        //     userService.deleteUserRest(user); 
        // }

    }

}
