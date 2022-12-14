package com.barclays.trade.confirmationlayer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to check the health of the application
 */
@RestController
public class HealthCheckController {

    /**
     *
     * @return Health Check message
     */
    @GetMapping("/health")
    public ResponseEntity<String> getHealthCheck(){
        return ResponseEntity.ok("Confirmation layer is UP");
    }
}
