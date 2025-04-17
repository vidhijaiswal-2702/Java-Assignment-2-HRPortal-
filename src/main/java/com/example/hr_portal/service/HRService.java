package com.example.hr_portal.service;

import com.example.hr_portal.model.HR;
import com.example.hr_portal.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRService {

    @Autowired
    private HRRepository hrRepo;

    // ✅ Login Logic
    public HR verifyCredentials(String email, String password) {
        return hrRepo.findByEmailAndPassword(email, password);
    }

    // ✅ Register New HR
    public HR registerHR(HR hr) {
        return hrRepo.save(hr);
    }

    // ✅ Check if email already exists
    public boolean emailExists(String email) {
        return hrRepo.findByEmail(email).isPresent();
    }
}
