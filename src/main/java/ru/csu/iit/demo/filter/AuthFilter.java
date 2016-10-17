package ru.csu.iit.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.csu.iit.demo.service.AuthService;

@ControllerAdvice
public class AuthFilter {

    @Autowired
    AuthService authService;

    @ModelAttribute
    public void auth(Model model) {
        if (authService.hasRole(AuthService.ROLE_USER)) {
            model.addAttribute("__user", true);
            model.addAttribute("__admin", false);
        } else if (authService.hasRole(AuthService.ROLE_ADMIN)) {
            model.addAttribute("__user", true);
            model.addAttribute("__admin", true);
        } else {
            model.addAttribute("__user", false);
            model.addAttribute("__admin", false);
        }
    }

}
