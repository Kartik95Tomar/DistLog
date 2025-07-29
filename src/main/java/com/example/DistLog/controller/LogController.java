package com.example.DistLog.controller;

import com.example.DistLog.exceptions.OffsetNotFound;
import com.example.DistLog.models.Record;
import com.example.DistLog.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {

    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/")
    public ResponseEntity<Long> addLog(@RequestBody Record record) {
        try {
            long offset = logService.handleProduce(record);
            return ResponseEntity.status(HttpStatus.CREATED).body(offset);
        } catch (Exception e) {
            e.printStackTrace(); // or use a logger
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{offset}")
    public ResponseEntity<Record> getLog(@PathVariable Long offset) {
        try {
            Record record = logService.handleConsume(offset);
            return ResponseEntity.status(HttpStatus.OK).body(record);
        } catch (OffsetNotFound e) {
            throw new RuntimeException(e);
        }
    }
}
