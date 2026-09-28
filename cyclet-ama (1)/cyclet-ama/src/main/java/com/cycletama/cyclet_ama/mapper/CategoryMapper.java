package com.cycletama.cyclet_ama.mapper;

import com.cycletama.cyclet_ama.dto.CategoryDTO;
import com.cycletama.cyclet_ama.entity.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
