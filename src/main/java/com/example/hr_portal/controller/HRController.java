package com.example.hr_portal.controller;

import com.example.hr_portal.exception.ResourceNotFoundException;
import com.example.hr_portal.model.HR;
import com.example.hr_portal.service.HRService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hr")
@CrossOrigin(origins = "http://localhost:8080")
public class HRController {

    @Autowired
    private HRService hrService;

    @PostMapping("/login")
    public HR login(@RequestBody HR hr) {
        HR hrUser = hrService.verifyCredentials(hr.getEmail(), hr.getPassword());

        if (hrUser == null) {
            throw new ResourceNotFoundException("Invalid email or password. Please try again.");
        }

        return hrUser;
    }
    @PostMapping("/register")
    public HR register(@RequestBody HR hr) {
        if (hrService.emailExists(hr.getEmail())) {
            throw new ResourceNotFoundException("Email already registered. Try logging in.");
        }
        return hrService.registerHR(hr);
    }

}
