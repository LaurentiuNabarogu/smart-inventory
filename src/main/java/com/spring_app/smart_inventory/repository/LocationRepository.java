package com.spring_app.smart_inventory.repository;

import com.spring_app.smart_inventory.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
