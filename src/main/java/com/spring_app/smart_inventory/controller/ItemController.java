package com.spring_app.smart_inventory.controller;

import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping("{id}")
    public ItemDTO getItem(@PathVariable UUID id){
        return itemService.get(id);
    }
    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        return itemService.create(itemDTO);
    }
    @PutMapping("{id}")
    public ItemDTO updateItem(@PathVariable UUID id, @RequestBody ItemDTO itemDTO) {
        return itemService.update(id, itemDTO);
    }
    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable UUID id){
        itemService.delete(id);
    }
    @GetMapping
    public List<ItemDTO> getItems() {
        return itemService.getAllItems();
    }
}
