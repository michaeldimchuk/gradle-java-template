package com.github.gradle.template.models.rest;

import lombok.NonNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

public record Fruit(
    @NonNull
    @Schema(example = "Omashu Cabbage Cart", description = "The name of the store.", required = true)
    String store,
    @NonNull
    @Schema(example = "USD", description = "The currency the price is in.", required = true)
    String currency,
    @NonNull
    @Schema(example = "Apple", description = "The name of the fruit.", required = true)
    String name,
    @NonNull
    @Schema(example = "0.99", description = "The price of the fruit per 100 grams.", required = true)
    BigDecimal price,
    @Schema(example = "24", description = "The units of fruit in inventory.", required = true)
    int count
) {}
