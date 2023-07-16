package com.github.gradle.template.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    SwaggerConfig.class,
    SpringConfig.class,
    HealthConfig.class
})
@Configuration
public class TemplateConfig {

}
