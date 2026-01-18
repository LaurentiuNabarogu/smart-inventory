package com.spring_app.smart_inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record CategoryDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UUID id,
        String name) {
}
