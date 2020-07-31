package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping
    public String displayUser(){
        return "user/index";
    }
    @GetMapping("add")
    public String displayAddUserForm(){
       return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        // add form submission handling code here

        if(errors.hasErrors() || !user.getPassword().equals(verify)){
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
        model.addAttribute("user" , user);
        return "user/index";

    }

}
