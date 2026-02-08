package com.vbs.demo.controller;

import com.vbs.demo.dto.InsuranceApplyDto;
import com.vbs.demo.models.Insurance;
import com.vbs.demo.models.User;
import com.vbs.demo.repositories.InsuranceRepo;
import com.vbs.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceRepo insuranceRepo;
    @Autowired
    private UserRepo userRepo;

    //    apply for insurance
    @PostMapping("/apply/{userId}")
    public String applyInsurance(@PathVariable int userId,
                                 @RequestBody InsuranceApplyDto dto) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Insurance insurance = new Insurance();
        insurance.setUser(user);

        insurance.setInsuranceType(dto.getInsuranceType());
        insurance.setAmount(dto.getAmount());
        insurance.setStatus("PENDING");
        insurance.setAppliedDate(LocalDate.now());
        insuranceRepo.save(insurance);
        return "Insurance applied successfully";
    }

    //    View own insurance
    @GetMapping("/my/{userId}")
    public List<Insurance> myInsurance(@PathVariable int userId) {
        return
                insuranceRepo.findByUserId(userId);
    }
}



