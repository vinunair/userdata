package com.github.vinunair.userdata.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.vinunair.userdata.domain.Search;
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
    public String saveUser(@Valid User user,BindingResult bindingResult,RedirectAttributes redirectAttrs) {
    	if(bindingResult.hasErrors())
    		return "useradd";
    	
        userDataService.saveUser(user);
        redirectAttrs.addAttribute("successMessage", "User data saved");
        return "redirect:/user/add";
    }
    
    @RequestMapping("user/search")
    public String searchUser(Model model) {
        model.addAttribute("search", new Search());
        return "usersearch";
    }
    
    @RequestMapping(value="search",method=RequestMethod.POST)
    public String search(Search search,Model model) {
    	model.addAttribute("users", userDataService.searchUserByName(search.getName()));
    	return "usersearch";
    }
}
