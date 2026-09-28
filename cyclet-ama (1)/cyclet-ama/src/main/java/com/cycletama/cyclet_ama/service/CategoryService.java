package com.cycletama.cyclet_ama.service;

import com.cycletama.cyclet_ama.dto.CategoryDTO;
import com.cycletama.cyclet_ama.dto.ProductDTO;
import com.cycletama.cyclet_ama.entity.Category;
import com.cycletama.cyclet_ama.exception.ProductNotFoundException;
import com.cycletama.cyclet_ama.mapper.CategoryMapper;
import com.cycletama.cyclet_ama.mapper.ProductMapper;
import com.cycletama.cyclet_ama.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private ProductMapper productMapper;

    public CategoryService(CategoryRepository categoryRepository , CategoryMapper categoryMapper , ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.productMapper = productMapper;
    }

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll()
                .stream().map(categoryMapper::toDTO).toList();
    }

    public CategoryDTO createCategory(Category category) {
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(saveCategory);
    }

    public Set<ProductDTO> getProductsByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ProductNotFoundException("category not found"));
        return category.getProducts().stream().map(productMapper::toDTO).collect(Collectors.toSet());
    }


}
