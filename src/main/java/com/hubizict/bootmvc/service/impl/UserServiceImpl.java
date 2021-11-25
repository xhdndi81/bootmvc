package com.hubizict.bootmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hubizict.bootmvc.mapper.UserMapper;
import com.hubizict.bootmvc.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getUserList() {

        return userMapper.getUserList();
    }

    @Override
    public Map<String, Object> getUser(String id) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ID", id);

        return userMapper.getUser(param);
    }
    
}
