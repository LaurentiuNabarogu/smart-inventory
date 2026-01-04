package com.spring_app.smart_inventory.repository;

import com.spring_app.smart_inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
