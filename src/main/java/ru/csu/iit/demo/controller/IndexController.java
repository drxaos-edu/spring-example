package ru.csu.iit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.csu.iit.demo.service.AuthService;
import ru.csu.iit.demo.service.UserService;

@Controller
public class IndexController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView index(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mv = new ModelAndView();

        String username = authService.getUsername();
        if (username != null) {
            mv.getModel().put("name", username);
        } else {
            mv.getModel().put("name", name);
        }

        mv.getModel().put("name", name);

        mv.getModel().put("u", userService.getUser("user"));

        mv.setViewName("index");
        return mv;
    }

}