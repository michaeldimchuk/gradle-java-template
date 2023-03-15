package com.github.gradle.template.api.controllers;

import com.github.gradle.template.models.rest.HealthResponse;
import com.github.gradle.template.models.rest.HealthStatus;
import com.github.gradle.template.services.health.HealthService;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class HealthController {

  HealthService healthService;

  @GetMapping
  HealthResponse checkHealth() {
    return HealthResponse.builder()
        .status(healthService.check() ? HealthStatus.OK : HealthStatus.FAILED)
        .build();
  }
}
