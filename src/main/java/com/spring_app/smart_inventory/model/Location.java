package com.spring_app.smart_inventory.model;

import com.spring_app.smart_inventory.enums.LocationType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    protected Location() {
        //for Hibernate
    }
    public Location(String name, LocationType type) {
        this.name = name;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }
}
