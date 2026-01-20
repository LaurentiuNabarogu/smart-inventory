package com.spring_app.smart_inventory.service;

import com.spring_app.smart_inventory.dto.ItemDTO;

import java.util.List;
import java.util.UUID;

public interface ItemService extends CrudService<ItemDTO, UUID>{
// metode extra specifice businessului
    List<ItemDTO> getByCategoryName(String categoryName);
    List<ItemDTO> getByLocationName(String locationName);
    List<ItemDTO> getByCategoryName_LocationNameContainingIgnoreCase(String categoryName, String locationName);
//    List<ItemDTO> getByName(String name);
//    List<ItemDTO> getBySerialNumber(String serialNumber);
//    List<ItemDTO> getByDescription(String description);
//    List<ItemDTO> getByCategoryId(UUID categoryId);

//ItemDTO changeStatus(UUID id, ItemStatus status);
//ItemDTO moveToLocation(UUID itemId, UUID locationId);



}
