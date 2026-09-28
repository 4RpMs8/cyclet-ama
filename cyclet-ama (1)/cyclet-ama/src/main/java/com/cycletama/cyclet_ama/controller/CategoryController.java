package com.cycletama.cyclet_ama.controller;

import com.cycletama.cyclet_ama.dto.CategoryDTO;
import com.cycletama.cyclet_ama.dto.ProductDTO;
import com.cycletama.cyclet_ama.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cycletama.cyclet_ama.entity.Category;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{categoryId}/products")
    public Set<ProductDTO> getAllProductsByCategory(@PathVariable final Long categoryId){
        return categoryService.getProductsByCategoryId(categoryId);
    }

}
