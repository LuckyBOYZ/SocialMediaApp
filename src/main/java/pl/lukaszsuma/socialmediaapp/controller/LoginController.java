package pl.lukaszsuma.socialmediaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @GetMapping
    public ModelAndView login(ModelAndView mav){
       mav.setViewName("index.html");
       return mav;
    }
}
