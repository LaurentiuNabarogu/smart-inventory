package com.spring_app.smart_inventory.util;

import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.model.Category;
import com.spring_app.smart_inventory.model.Item;
import com.spring_app.smart_inventory.model.Location;

public class ModelConvertor {

    public static ItemDTO toItemDTO(Item item){
            return new ItemDTO(
                    item.getId(),
                    item.getName(),
                    item.getDescription(),
                    item.getCategory().getId(),
                    item.getLocation().getId(),
                    item.getSerialNumber(),
                    item.getStatus(),
                    item.getCreatedAt()
                    );

    }
    public static Item toItem(ItemDTO dto, Category category, Location location){
        return new Item(
                dto.name(),
                dto.description(),
                category,
                location,
                dto.serialNumber(),
                dto.status()
        );
    }

}
