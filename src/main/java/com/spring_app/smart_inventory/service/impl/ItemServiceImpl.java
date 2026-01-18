package com.spring_app.smart_inventory.service.impl;

import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.model.Category;
import com.spring_app.smart_inventory.model.Item;
import com.spring_app.smart_inventory.model.Location;
import com.spring_app.smart_inventory.repository.CategoryRepository;
import com.spring_app.smart_inventory.repository.ItemRepository;
import com.spring_app.smart_inventory.repository.LocationRepository;
import com.spring_app.smart_inventory.service.ItemService;
import com.spring_app.smart_inventory.util.ModelConvertor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, LocationRepository locationRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;

    }
    @Override
    public ItemDTO create(ItemDTO dto) {
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
        Location location = locationRepository.findById(dto.locationId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        Item item = new Item(
                dto.name(),
                dto.description(),
                category,
                location,
                dto.serialNumber(),
                dto.status()
                );
        Item createdItem = itemRepository.save(item);
        return ModelConvertor.toItemDTO(createdItem);

    }

    @Override
    public ItemDTO getById(UUID id) {
            Item item =  itemRepository.findById(id).orElseThrow();
            return ModelConvertor.toItemDTO(item);
    }

    @Override
    public ItemDTO update(UUID id, ItemDTO dto) {

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
        Location location = locationRepository.findById(dto.locationId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        Item item = new Item(
                dto.name(),
                dto.description(),
                category,
                location,
                dto.serialNumber(),
                dto.status()
        );
        item.setId(id);
        Item updateItem = itemRepository.save(item);
        return ModelConvertor.toItemDTO(updateItem);

    }

    @Override
    public void delete(UUID id) {

        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemDTO> getAll() {
        List<Item> allItems = itemRepository.findAll();
        return allItems.stream().map(ModelConvertor::toItemDTO).toList();
    }

}
