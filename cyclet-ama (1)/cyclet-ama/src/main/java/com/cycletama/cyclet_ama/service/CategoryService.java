package com.cycletama.cyclet_ama.service;

import com.cycletama.cyclet_ama.dto.CategoryDTO;
import com.cycletama.cyclet_ama.entity.Category;
import com.cycletama.cyclet_ama.mapper.CategoryMapper;
import com.cycletama.cyclet_ama.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository , CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll()
                .stream().map(categoryMapper::toDTO).toList();
    }

    public CategoryDTO createCategory(Category category) {
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(saveCategory);
    }
}
