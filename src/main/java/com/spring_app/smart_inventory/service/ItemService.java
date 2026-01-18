package com.spring_app.smart_inventory.service;

import com.spring_app.smart_inventory.dto.ItemDTO;

import java.util.UUID;

public interface ItemService extends CrudService<ItemDTO, UUID>{
// metode extra specifice businessului
//    List<ItemDTO> getByCategory(ItemDTO itemDTO);
//    List<ItemDTO> getByName(String name);
//    List<ItemDTO> getBySerialNumber(String serialNumber);
//    List<ItemDTO> getByDescription(String description);
//    List<ItemDTO> getByCategoryId(UUID categoryId);

//ItemDTO changeStatus(UUID id, ItemStatus status);
//ItemDTO moveToLocation(UUID itemId, UUID locationId);



}
