package com.spring_app.smart_inventory.controller;

import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Tag(name="Item API", description = "This is an API for the CRUD operations of the Items in the DB")
@RestController
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @Operation(summary = "Get Item", description = "Retrieves an item from the DB based on the id.")
    @GetMapping("{id}")
    public ItemDTO getItem(@PathVariable UUID id){
        return itemService.getById(id);
    }
    @Operation(summary = "Create Item", description = "Creates a new item in DB.")
    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        return itemService.create(itemDTO);
    }
    @Operation(summary = "Update Item", description = "Updates an existent item in the DB")
    @PutMapping("{id}")
    public ItemDTO updateItem(@PathVariable UUID id, @RequestBody ItemDTO itemDTO) {
        return itemService.update(id, itemDTO);
    }
    @Operation(summary = "Delete Item", description = "Permanently Deletes an item from the DB.")
    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable UUID id){
        itemService.delete(id);
    }
    @Operation(summary = "Get All Items", description = "Get all the items.")
    @GetMapping
    public List<ItemDTO> getItems() {
        return itemService.getAll();
    }
}
