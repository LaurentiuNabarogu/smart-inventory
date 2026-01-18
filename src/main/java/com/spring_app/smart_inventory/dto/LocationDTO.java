package com.spring_app.smart_inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_app.smart_inventory.enums.LocationType;

import java.util.UUID;

public record LocationDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UUID id,
        String name,
        LocationType type) {
}
