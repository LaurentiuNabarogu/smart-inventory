package com.spring_app.smart_inventory.service.impl;

import com.spring_app.smart_inventory.dto.CategoryDTO;
import com.spring_app.smart_inventory.model.Category;
import com.spring_app.smart_inventory.repository.CategoryRepository;
import com.spring_app.smart_inventory.service.CategoryService;
import com.spring_app.smart_inventory.util.ModelConvertor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        Category category = new Category(dto.name());
        Category saved = categoryRepository.save(category);
        return ModelConvertor.toCategoryDTO(saved);
    }

    @Override
    public CategoryDTO getById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return ModelConvertor.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO update(UUID id, CategoryDTO dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        category.setName(dto.name());
        Category updated = categoryRepository.save(category);
        return ModelConvertor.toCategoryDTO(updated);
    }

    @Override
    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(ModelConvertor::toCategoryDTO)
                .collect(Collectors.toList());
    }
}
