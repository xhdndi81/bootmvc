package com.hubizict.bootmvc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    
    List<Map<String, Object>> getUserList();

    Map<String, Object> getUser(Map<String, Object> param);

    void updateUser(Map<String, Object> param);

    void deleteUser(String id);

    void insertUser(Map<String, Object> user);   

}
