package com.spring_app.smart_inventory.controller;

import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.dto.LocationDTO;
import com.spring_app.smart_inventory.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name="Location API", description = "This is an API for the CRUD operations of the Locations in the DB")
@RestController
@RequestMapping("Locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @Operation(summary = "Create Location", description = "Creates a new location in DB.")
    @PostMapping
    public LocationDTO createLocation(@RequestBody LocationDTO dto) {
        return locationService.create(dto);
    }

    @Operation(summary = "Get Location", description = "Retrieves a location from the DB based on the id.")
    @GetMapping("{id}")
    public LocationDTO getLocation(@PathVariable UUID id){
        return locationService.getById(id);
    }

    @Operation(summary = "Update Location", description = "Updates an existent location in the DB")
    @PutMapping("{id}")
    public LocationDTO updateLocation(@PathVariable UUID id, @RequestBody LocationDTO dto) {
        return locationService.update(id, dto);
    }

    @Operation(summary = "Delete Location", description = "Permanently deletes a location from the DB.")
    @DeleteMapping("{id}")
    public void deleteLocation(@PathVariable UUID id){
        locationService.delete(id);
    }

    @Operation(summary = "Get All Locations", description = "Get all the existing locations.")
    @GetMapping
    public List<LocationDTO> getLocations() {
        return locationService.getAll();
    }

}
