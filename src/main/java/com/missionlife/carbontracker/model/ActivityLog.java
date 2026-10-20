package com.missionlife.carbontracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;

@Document(collection = "activity_logs")
@Data
public class ActivityLog {
    
    @Id
    private String id;
    
    private Long userId; // SQL wale user ka reference
    private String activityType; // Jaise: 'Transport', 'Energy'
    private String actionDetails; // Jaise: 'Petrol Car', 'Bicycle'
    private double quantity; // Jaise: 5 km, 2 units
    private double carbonEmittedGrams;
    private int pointsAwarded;
    private Date timestamp = new Date();
}