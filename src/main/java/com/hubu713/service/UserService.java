package com.hubu713.service;

import com.hubu713.mapper.UserMapper;
import com.hubu713.pojo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;
    public User userLogin(String username, String password) {
        return userMapper.findUserByNameAndPswd(username,password);
    }

    public void userRegist(String username, String password, String telephone, int age, Timestamp creatTime, Timestamp updateTime) {
        userMapper.addUser(username,password,telephone,age,creatTime,updateTime);
    }

    public boolean findUser(String username) {
        User s=userMapper.findUserByName(username);
        if(s!=null){
            return true;
        }else{
            return false;
        }

    }
}
