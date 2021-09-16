package com.example.demo.controller;

import com.example.demo.model.Model;
import com.example.demo.repo.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    MyRepo myRepo;

    @GetMapping("/")
    public String getValue(){
        return "mainIndex.html";
    }

    @PostMapping("/save")
    public ModelAndView saveValue(@ModelAttribute Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-value.html");
        modelAndView.addObject("model" , model);
        myRepo.save(model);
        return modelAndView;
    }





}
