package com.github.gradle.template.api.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.gradle.template.models.rest.HealthResponse;
import com.github.gradle.template.models.rest.HealthStatus;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TemplateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TemplateApplicationTest {

  RestTemplate restTemplate = new RestTemplate();

  @NonFinal
  @LocalServerPort
  int randomServerPort;

  @Test
  void checkHealthTest() {
    var response = restTemplate.getForEntity(getUrl("/health"), HealthResponse.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    var body = response.getBody();
    assertThat(body).isNotNull();
    assertThat(body.getStatus()).isEqualTo(HealthStatus.OK);
  }

  private String getUrl(String endpoint) {
    return "http://localhost:" + randomServerPort + endpoint;
  }
}
