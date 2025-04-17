package com.example.hr_portal.repository;

import com.example.hr_portal.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HRRepository extends JpaRepository<HR, Long> {
    HR findByEmailAndPassword(String email, String password);
    Optional<HR> findByEmail(String email);
}
