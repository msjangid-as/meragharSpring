package com.meraghar.meraghar.controller;

import com.meraghar.meraghar.dao.UserRepo;
import com.meraghar.meraghar.entities.User;
import com.meraghar.meraghar.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title","Home - Mera Apna Ghar");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About");
        return "about";
    }

    @RequestMapping("/Contact")
    public String Contact(Model model){
        model.addAttribute("title","Contact");
        return "Contact";
    }

    @RequestMapping("/help")
    public String help(Model model){
        model.addAttribute("title","Help");
        return "help";
    }
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Register");
        model.addAttribute("user",new User());
        return "signup";
    }

    @RequestMapping(value = "/do_register",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user")
           User user, @RequestParam(value = "flexCheck",defaultValue = "false")
            boolean agreement, Model model, HttpSession session){
        try {
            user.setRole("ROLE_USER");
            user.setActive(true);

            model.addAttribute("user", user);
            System.out.println("Agreement :: " + agreement);
            System.out.println("User :: " + user);
            User result = this.userRepo.save(user);
            model.addAttribute("user",new User());
            session.setAttribute("message", new Messages("Successfully Registered... "
                    ,"alert-success"));
            return "signup";

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message", new Messages("Something went wrong "+e.getMessage()
                    ,"alert-danger"));
            return "signup";
        }

    }
}
