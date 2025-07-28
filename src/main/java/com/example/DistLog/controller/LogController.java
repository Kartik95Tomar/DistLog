package com.example.DistLog.controller;

import com.example.DistLog.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {

    private LogService logService;

    LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addLog() {
        return ResponseEntity.ok(logService.handleProduce());
    }

    @GetMapping("/")
    public ResponseEntity<String> getLog() {
        return ResponseEntity.ok(logService.handleConsume());
    }
}
