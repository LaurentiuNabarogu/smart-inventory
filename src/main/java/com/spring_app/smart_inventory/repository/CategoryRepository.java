package com.spring_app.smart_inventory.repository;

import com.spring_app.smart_inventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
