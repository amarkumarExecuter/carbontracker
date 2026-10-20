package com.missionlife.carbontracker.repository;

import com.missionlife.carbontracker.model.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepository extends MongoRepository<ActivityLog, String> {
    // User ke ID ke hisaab se saari activities nikalne ke liye
    List<ActivityLog> findByUserId(Long userId);
}