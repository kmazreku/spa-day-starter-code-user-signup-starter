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
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        // add form submission handling code here
        model.addAttribute("user" , user);
        if(errors.hasErrors() || !user.getPassword().equals(verify)){
            model.addAttribute("errorPass", "Password and Verify Password should match.");
            return "user/add";
        }

        return "user/index";

    }

}
