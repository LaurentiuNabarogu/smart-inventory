package com.spring_app.smart_inventory.service.impl;

import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.model.Category;
import com.spring_app.smart_inventory.model.Item;
import com.spring_app.smart_inventory.repository.ItemRepository;
import com.spring_app.smart_inventory.service.ItemService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public ItemDTO create(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.name(), itemDTO.description(), itemDTO.categoryId(), itemDTO.serialNumber(), itemDTO.createdAt());
        Item createdItem = itemRepository.save(item);
        return toItemDTO(createdItem);

    }

    @Override
    public ItemDTO update(UUID id, ItemDTO itemDTO) {
        Item item = new Item(itemDTO.name(), itemDTO.description(), itemDTO.categoryId(), itemDTO.serialNumber(), itemDTO.createdAt());
        item.setId(id);
        Item updateItem = itemRepository.save(item);
        return toItemDTO(updateItem);

    }

    @Override
    public void delete(UUID id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDTO get(UUID id) {
        Item item =  itemRepository.findById(id).orElseThrow();
        return toItemDTO(item);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> allItems = itemRepository.findAll();
        return allItems.stream().map(this::toItemDTO).toList();
    }
    private ItemDTO toItemDTO(Item item){
        return new ItemDTO(item.getId(), item.getName(), item.getDescription(), item.getCategoryId(), item.getSerialNumber(), item.getCreatedAt());
    }
}
