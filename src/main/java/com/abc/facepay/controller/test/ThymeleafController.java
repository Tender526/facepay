package com.abc.facepay.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("getDemoHtml")
    public ModelAndView getDemoHtml(){
        ModelAndView view = new ModelAndView();
        view.addObject("viewname","view");
        view.addObject("viewage","view-18");

        view.setViewName("demo");
        return view;
    }
}
