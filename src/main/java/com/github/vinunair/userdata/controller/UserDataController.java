package com.github.vinunair.userdata.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String saveUser(@Valid User user,BindingResult bindingResult) {
    	if(bindingResult.hasErrors())
    		return "useradd";
    	
        userDataService.saveUser(user);
        return "redirect:/user/add";
    }
    
    @RequestMapping("user/search/{name}")
    public String searchUser(@PathVariable String name,Model model) {
    	model.addAttribute("users", userDataService.searchUserByName(name));
    	return "usersearch";
    }
}
