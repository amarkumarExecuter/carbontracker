package com.missionlife.carbontracker.controller;

import com.missionlife.carbontracker.model.ActivityLog;
import com.missionlife.carbontracker.model.User;
import com.missionlife.carbontracker.repository.UserRepository;
import com.missionlife.carbontracker.service.CarbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/carbon")
@CrossOrigin(origins = "*") // Frontend se connect karne ke liye
public class CarbonController {

    @Autowired
    private CarbonService carbonService;

    @Autowired
    private UserRepository userRepository;

    // 1. Test API
    @GetMapping("/test")
    public String testApi() {
        return "Mission LiFE Carbon Tracker Backend is Running Successfully! 🚀";
    }

    // 2. Naya User Register karne ke liye API
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 3. Activity add karne aur Carbon calculate karne ki API
    @PostMapping("/add-activity")
    public ActivityLog addActivity(@RequestBody Map<String, Object> request) {
        Long userId = Long.valueOf(request.get("userId").toString());
        String activityType = request.get("activityType").toString();
        String actionDetails = request.get("actionDetails").toString();
        double quantity = Double.parseDouble(request.get("quantity").toString());

        return carbonService.calculateAndSaveActivity(userId, activityType, actionDetails, quantity);
    }
}