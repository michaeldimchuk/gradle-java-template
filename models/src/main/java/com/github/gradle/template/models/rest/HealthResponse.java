package com.github.gradle.template.models.rest;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class HealthResponse {
  HealthStatus status;
}
