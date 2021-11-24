package com.hubizict.bootmvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hubizict.bootmvc.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<Map<String, Object>> getUserList() {

        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();

        Map<String, Object> user1 = new HashMap<String, Object>();
        user1.put("name", "김경식");

        Map<String, Object> user2 = new HashMap<String, Object>();
        user2.put("name", "전혜린");

        Map<String, Object> user3 = new HashMap<String, Object>();
        user3.put("name", "박세희");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
    
}
