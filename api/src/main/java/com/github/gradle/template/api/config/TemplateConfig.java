package com.github.gradle.template.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    SpringConfig.class,
    HealthConfig.class
})
@Configuration
public class TemplateConfig {

}
