package com.github.gradle.template.api.config;

import com.github.gradle.template.api.controllers.HealthController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    HealthConfig.class
})
@Configuration
public class WebConfig {

}
