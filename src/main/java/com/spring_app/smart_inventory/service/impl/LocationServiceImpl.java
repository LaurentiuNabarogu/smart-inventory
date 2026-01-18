package com.spring_app.smart_inventory.service.impl;

import com.spring_app.smart_inventory.dto.LocationDTO;
import com.spring_app.smart_inventory.model.Location;
import com.spring_app.smart_inventory.repository.LocationRepository;
import com.spring_app.smart_inventory.service.LocationService;
import com.spring_app.smart_inventory.util.ModelConvertor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationDTO create(LocationDTO dto) {
        Location location = new Location(dto.name(), dto.type());
        Location saved = locationRepository.save(location);
        return ModelConvertor.toLocationDTO(saved);
    }

    @Override
    public LocationDTO getById(UUID id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        return ModelConvertor.toLocationDTO(location);
    }

    @Override
    public LocationDTO update(UUID id, LocationDTO dto) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        location.setName(dto.name());
        location.setType(dto.type());
        Location updated = locationRepository.save(location);
        return ModelConvertor.toLocationDTO(updated);
    }

    @Override
    public void delete(UUID id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<LocationDTO> getAll() {
        return locationRepository.findAll()
                .stream()
                .map(ModelConvertor::toLocationDTO)
                .collect(Collectors.toList());
    }
}
