package com.missionlife.carbontracker.service;

import com.missionlife.carbontracker.model.ActivityLog;
import com.missionlife.carbontracker.model.User;
import com.missionlife.carbontracker.repository.ActivityLogRepository;
import com.missionlife.carbontracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarbonService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ActivityLog calculateAndSaveActivity(Long userId, String activityType, String actionDetails, double quantity) {
        double carbonGrams = 0;
        int points = 0;

        if (activityType.equalsIgnoreCase("Transport")) {
            if (actionDetails.equalsIgnoreCase("Petrol Car")) {
                carbonGrams = quantity * 192;
                points = 0;
            } else if (actionDetails.equalsIgnoreCase("Public Bus")) {
                carbonGrams = quantity * 80;
                points = 10;
            } else if (actionDetails.equalsIgnoreCase("Bicycle")) {
                carbonGrams = 0;
                points = 30;
            }
        } else if (activityType.equalsIgnoreCase("Energy")) {
            if (actionDetails.equalsIgnoreCase("Electricity")) {
                carbonGrams = quantity * 820;
                points = 0;
            } else if (actionDetails.equalsIgnoreCase("Solar")) {
                carbonGrams = 0;
                points = 50;
            }
        }

        ActivityLog log = new ActivityLog();
        log.setUserId(userId);
        log.setActivityType(activityType);
        log.setActionDetails(actionDetails);
        log.setQuantity(quantity);
        log.setCarbonEmittedGrams(carbonGrams);
        log.setPointsAwarded(points);
        
        ActivityLog savedLog = activityLogRepository.save(log);

        User user = userRepository.findById(userId).orElseGet(() -> {
            User newUser = new User();
            newUser.setId(userId);
            newUser.setTotalEcoPoints(0);
            newUser.setCurrentBadge("Eco-Beginner 🌱");
            return userRepository.save(newUser);
        });

        user.setTotalEcoPoints(user.getTotalEcoPoints() + points);
        if (user.getTotalEcoPoints() > 100) {
            user.setCurrentBadge("Eco-Warrior 🌿");
        }
        userRepository.save(user);

        return savedLog;
    }
}