package com.cycletama.cyclet_ama.mapper;

import com.cycletama.cyclet_ama.dto.ProductModelDTO;
import com.cycletama.cyclet_ama.entity.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductModelMapper {
    public ProductModelDTO toDTO(ProductModel productModel) {
        ProductModelDTO dto = new ProductModelDTO();

        dto.setId(productModel.getId());
        dto.setModel(productModel.getModel());
        dto.setProductCode(productModel.getProductCode());
        dto.setPricePerCarton(productModel.getPricePerCarton());
        dto.setStock(productModel.getStock());
        dto.setPiecesPerCarton(productModel.getPiecesPerCarton());
        dto.setStatus(productModel.getStatus());
        return dto;

    }
}
