package com.github.gradle.template.api.application;

import com.github.gradle.template.api.config.TemplateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

@Import(TemplateConfig.class)
public class TemplateApplication {
  public static void main(String[] args) {
    SpringApplication.run(TemplateApplication.class, args);
  }
}
