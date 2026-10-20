package com.missionlife.carbontracker.controller;

import com.missionlife.carbontracker.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AiController {

    @Autowired
    private AiService aiService;

    @PostMapping("/chat")
    public Map<String, String> chatWithAi(@RequestBody Map<String, String> request) {
        String prompt = request.get("message");
        String reply = aiService.getAiCoachResponse(prompt);
        return Map.of("response", reply);
    }
}