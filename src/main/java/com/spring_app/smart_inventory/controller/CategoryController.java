package com.spring_app.smart_inventory.controller;

import com.spring_app.smart_inventory.dto.CategoryDTO;
import com.spring_app.smart_inventory.dto.ItemDTO;
import com.spring_app.smart_inventory.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name="Category API", description = "This is an API for the CRUD operations of the Categories in the DB")
@RestController
@RequestMapping("Categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create Category", description = "Creates a new category in DB.")
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO dto) {
        return categoryService.create(dto);
    }

    @Operation(summary = "Get Category", description = "Retrieves a category from the DB based on the id.")
    @GetMapping("{id}")
    public CategoryDTO getCategory(@PathVariable UUID id){
        return categoryService.getById(id);
    }

    @Operation(summary = "Update Category", description = "Updates an existent category in the DB")
    @PutMapping("{id}")
    public CategoryDTO updateCategory(@PathVariable UUID id, @RequestBody CategoryDTO dto) {
        return categoryService.update(id, dto);
    }

    @Operation(summary = "Delete Category", description = "Permanently deletes a category from the DB.")
    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable UUID id){
        categoryService.delete(id);
    }

    @Operation(summary = "Get All Categories", description = "Get all the existing categories.")
    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getAll();
    }
}
