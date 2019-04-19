package com.hubu713.controller;

import com.hubu713.pojo.User;
import com.hubu713.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> userLogin(String username, String password, HttpSession session){
        User user = null;
        user=userService.userLogin(username,password);
        HashMap<String,Object> map = new HashMap<>();
        if(user!=null){
            session.setAttribute("username",username);
            //0表示登陆成功；
            map.put("msg",0);
            return map;
        }
        else{
            //1表示登陆失败；
            map.put("msg",1);
            return map;
        }
    }
    @RequestMapping(value = "/userRegist",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> userRegist(String username,String password,String telephone,int age){
        boolean i=userService.findUser(username);
        HashMap<String,Object> map = new HashMap<>();
        if (i==true){
            //0表示用户名已经存在！
            map.put("msg",0);
            return map;
        }else{
            Timestamp creatTime = new Timestamp(System.currentTimeMillis());
            Timestamp updateTime = new Timestamp(System.currentTimeMillis());
            userService.userRegist(username,password,telephone,age,creatTime,updateTime);
            //1表示注册成功
            map.put("msg",1);
            return map;
        }
    }

    @GetMapping("/getUsername")
    @ResponseBody
    public HashMap<String,Object> getusername(HttpSession session){
        String username=(String)session.getAttribute("username");
        //System.out.println(username);
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",username);
        return map;
    }

    @GetMapping("/exit")
    @ResponseBody
    public HashMap<String,Object> exit(HttpSession session){
        session.removeAttribute("username");
        HashMap<String,Object> map=new HashMap<>();
        map.put("msg","退出成功");
        return map;
    }
}
