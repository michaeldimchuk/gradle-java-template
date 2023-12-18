package com.github.gradle.template.api.controllers;

import com.github.gradle.template.models.rest.Fruit;
import com.github.gradle.template.services.fruit.FruitService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RunOnVirtualThread
@Path("/v1/fruit")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class FruitController {

  FruitService fruitService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Fruit> getCatalog() {
    return fruitService.getCatalog();
  }
}
