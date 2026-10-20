package com.missionlife.carbontracker.service;

import com.missionlife.carbontracker.model.ActivityLog;
import com.missionlife.carbontracker.model.User;
import com.missionlife.carbontracker.repository.ActivityLogRepository;
import com.missionlife.carbontracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarbonService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private UserRepository userRepository;

    // Carbon Footprint aur Points calculate karne ka logic
    public ActivityLog calculateAndSaveActivity(Long userId, String activityType, String actionDetails, double quantity) {
        double carbonGrams = 0;
        int points = 0;

        // Mission LiFE Dataset Calculation Logic
        if (activityType.equalsIgnoreCase("Transport")) {
            if (actionDetails.equalsIgnoreCase("Petrol Car")) {
                carbonGrams = quantity * 192; // 192g CO2 per km
                points = 0;
            } else if (actionDetails.equalsIgnoreCase("Public Bus")) {
                carbonGrams = quantity * 80; // 80g CO2 per km
                points = 10;
            } else if (actionDetails.equalsIgnoreCase("Bicycle")) {
                carbonGrams = 0;
                points = 30; // Eco-friendly action
            }
        } else if (activityType.equalsIgnoreCase("Energy")) {
            if (actionDetails.equalsIgnoreCase("Electricity")) {
                carbonGrams = quantity * 820; // 820g CO2 per unit
                points = 0;
            } else if (actionDetails.equalsIgnoreCase("Solar")) {
                carbonGrams = 0;
                points = 50; // Green Energy reward
            }
        }

        // 1. Activity ko MongoDB mein save karna
        ActivityLog log = new ActivityLog();
        log.setUserId(userId);
        log.setActivityType(activityType);
        log.setActionDetails(actionDetails);
        log.setQuantity(quantity);
        log.setCarbonEmittedGrams(carbonGrams);
        log.setPointsAwarded(points);
        
        ActivityLog savedLog = activityLogRepository.save(log);

        // 2. User ke total points aur badge ko MySQL mein update karna (Gamification)
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setTotalEcoPoints(user.getTotalEcoPoints() + points);
            
            // Badge Upgrade Logic
            if (user.getTotalEcoPoints() > 100) {
                user.setCurrentBadge("Eco-Warrior 🌿");
            }
            userRepository.save(user);
        }

        return savedLog;
    }
}