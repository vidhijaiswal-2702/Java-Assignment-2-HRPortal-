package com.example.hr_portal.service;

import com.example.hr_portal.model.HR;
import com.example.hr_portal.repository.HRRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HRServiceImpl implements HRService {

    @Autowired
    private HRRepository hrRepository;

    @Override
    public void registerHR(HR hr) {
        hrRepository.save(hr);
    }

    @Override
    public Optional<HR> findHRByEmail(String email) {
        return hrRepository.findByEmail(email);
    }
}