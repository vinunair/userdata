package com.github.vinunair.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.vinunair.userdata.domain.User;
import com.github.vinunair.userdata.service.UserDataService;

@Controller
public class UserDataController {

    private UserDataService userDataService;

    @Autowired
    public void setUserDataService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping("user/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "useradd";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userDataService.saveUser(user);
        return "redirect:/user/add";
    }

}
