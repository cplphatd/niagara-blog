package com.codeup.controllers;

import com.codeup.models.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by David on 2/13/17.
 */
@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm() {

//        System.out.println(BCrypt.hashpw("codeup", BCrypt.gensalt(12)));

        return "users/login";
    }

    @GetMapping("/register")
    public String showRegisterForm (Model model) {

        model.addAttribute("user", new User());

        return "users/register";
    }
}
