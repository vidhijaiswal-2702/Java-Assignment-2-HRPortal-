package com.example.hr_portal.controller;

import com.example.hr_portal.model.HR;
import com.example.hr_portal.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HRAuthController {

    @Autowired
    private HRService hrService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("hr", new HR());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute HR hr, Model model) {
        // Basic password matching (in a real app, hash passwords!)
        if (hr.getPassword() != null && !hr.getPassword().isEmpty()) {
            hrService.registerHR(hr);
            model.addAttribute("registrationSuccess", "Registration successful! Please log in.");
            return "login"; // Redirect to login after successful registration
        } else {
            model.addAttribute("error", "Password cannot be empty.");
            return "register";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<HR> hrUser = hrService.findHRByEmail(email);

        if (hrUser.isPresent() && hrUser.get().getPassword().equals(password)) {
            // Authentication successful
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }
}