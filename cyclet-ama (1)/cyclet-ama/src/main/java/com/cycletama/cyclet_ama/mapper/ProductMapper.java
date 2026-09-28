package com.cycletama.cyclet_ama.mapper;


import com.cycletama.cyclet_ama.dto.ProductDTO;
import com.cycletama.cyclet_ama.entity.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    private final CategoryMapper categoryMapper;
    private final ProductModelMapper productModelMapper;

    public ProductMapper(CategoryMapper categoryMapper, ProductModelMapper productModelMapper) {
        this.categoryMapper = categoryMapper;
        this.productModelMapper = productModelMapper;
    }

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategories(product.getCategories().stream().map(categoryMapper::toDTO).collect(Collectors.toSet()));
        productDTO.setModels(product.getModels().stream().map(productModelMapper::toDTO).collect(Collectors.toSet()));
        return productDTO;
    }
}
