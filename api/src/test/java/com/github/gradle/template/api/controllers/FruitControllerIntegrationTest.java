package com.github.gradle.template.api.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.gradle.template.models.rest.Fruit;
import com.github.gradle.template.services.fruit.FruitService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@RequiredArgsConstructor(onConstructor_ = @Inject)
class FruitControllerIntegrationTest {

  private static final TypeReference<List<Fruit>> FRUIT = new TypeReference<>() {
  };

  FruitService fruitService;

  @Test
  void getCatalogTest() {
    final List<Fruit> body = RestAssured.given()
        .get("/v1/fruit")
        .then()
        .assertThat()
        .statusCode(Response.Status.OK.getStatusCode())
        .extract()
        .as(FRUIT.getType());
    assertThat(body).isEqualTo(fruitService.getCatalog());
  }
}
