package com.example.BUYsell.Controllers;

import com.example.BUYsell.Models.User;
import com.example.BUYsell.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration/user")
    public String createUser(@RequestParam String name, @RequestParam String phoneNumber,
                             @RequestParam String email, @RequestParam String password){
        userService.createUser(email, password, name, phoneNumber);
        return "redirect:/profile/user/{id}";
    }
    @GetMapping("/profile/user/{id}")
    public String profile(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "profile";
    }
}
