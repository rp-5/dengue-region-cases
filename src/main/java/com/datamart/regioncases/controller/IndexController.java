package com.datamart.regioncases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/registered")
    public ModelAndView getList() {
        ModelAndView mv = new ModelAndView("registered");
        return mv;
    }
}