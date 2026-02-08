package com.vbs.demo.controller;

import com.vbs.demo.models.Insurance;
import com.vbs.demo.repositories.InsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {
    @Autowired
    private InsuranceRepo insuranceRepo;

    //        view pending insurance
    @GetMapping("/pending")
    public List<Insurance> pendingInsurance() {
        return
                insuranceRepo.findByStatus("PENDING");
    }

    //        Approve or Reject
    @PutMapping("/update/{id}/{status}")
    public String updateStatus(
            @PathVariable int id,
            @PathVariable String status) {
        Insurance insurance = insuranceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
        insurance.setStatus(status.toUpperCase());
        insuranceRepo.save(insurance);
        return "Insurance " + status + " successfully";
    }
}
