package com.spring_app.smart_inventory.service;

import com.spring_app.smart_inventory.dto.ItemDTO;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemDTO create(ItemDTO itemDTO);
    ItemDTO get(UUID id);
    ItemDTO update(UUID id, ItemDTO itemDTO);
    void delete(UUID id);

    List<ItemDTO> getAllItems();
//    List<ItemDTO> getByCategory(ItemDTO itemDTO);
//    List<ItemDTO> getByName(String name);
//    List<ItemDTO> getBySerialNumber(String serialNumber);
//    List<ItemDTO> getByDescription(String description);
//    List<ItemDTO> getByCategoryId(UUID categoryId);
//


}
