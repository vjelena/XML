package com.example.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.xml.model.Registration;
/**
 * Kontroler vezan za krajnjeg korisnika
 */
@Controller
public class UserController {

	@GetMapping("/registration") //prvo prikazujemo html stranicu
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("registration", "registration", new Registration());
    }
}
