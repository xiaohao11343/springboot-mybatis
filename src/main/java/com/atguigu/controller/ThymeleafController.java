package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/demo")
    public String demo(Model model){
        model.addAttribute("hello","hello world");
        return "demo";
    }
}
