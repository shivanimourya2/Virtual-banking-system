package com.vbs.demo.repositories;

import com.vbs.demo.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepo extends JpaRepository<Insurance,Integer> {
    List<Insurance> findByStatus(String status);
    List<Insurance> findByUserId(int userId);
}
