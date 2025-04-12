package com.example.hr_portal.service;

import com.example.hr_portal.model.HR;

import java.util.Optional;

public interface HRService {
    void registerHR(HR hr);
    Optional<HR> findHRByEmail(String email);
}
