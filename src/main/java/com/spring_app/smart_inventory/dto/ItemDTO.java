package com.spring_app.smart_inventory.dto;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

public record ItemDTO(UUID id,String name,String description, UUID categoryId, String serialNumber, Instant createdAt) {

}
