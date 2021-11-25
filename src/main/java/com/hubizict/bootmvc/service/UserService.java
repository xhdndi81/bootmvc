package com.hubizict.bootmvc.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    
    public List<Map<String, Object>> getUserList();
    public Map<String, Object> getUser(String id);
    public void updateUser(Map<String, Object> user);
    public void deleteUser(String id);
    public void insertUser(Map<String, Object> user);

}
