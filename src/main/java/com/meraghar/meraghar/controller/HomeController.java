package com.meraghar.meraghar.controller;

import com.meraghar.meraghar.dao.UserRepo;
import com.meraghar.meraghar.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        User user=new User();
        user.setName("Madhusudhan");
        user.setEmail("jangidms8824@gmail.com");
        userRepo.save(user);
        return "Working";
    }
}
