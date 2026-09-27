package com.cycletama.cyclet_ama.controller;


import com.cycletama.cyclet_ama.dto.ProductModelDTO;
import com.cycletama.cyclet_ama.entity.ProductModel;
import com.cycletama.cyclet_ama.service.ProductModelService;
import org.springframework.web.bind.annotation.*;
import com.cycletama.cyclet_ama.dto.CreatProductModelRequest;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductModelController {
    private final ProductModelService productModelService;

    public ProductModelController(ProductModelService productModelService) {
        this.productModelService = productModelService;
    }

    @GetMapping("/{productId}/models")
    public List<ProductModelDTO> getModelsByProductId(@PathVariable Long productId) {
        return productModelService.getModelsByProductId(productId);
    }

    @PostMapping("/{productId}/models")
    public ProductModelDTO createProductModel(@PathVariable Long productId ,@RequestBody CreatProductModelRequest request) {
        return productModelService.createProductModel(productId , request);
    }

    @PutMapping("/{productId}/models/{modelId}")
    public ProductModelDTO updateProductModel(@PathVariable Long productId, @PathVariable Long modelId ,@RequestBody CreatProductModelRequest request) {
        return productModelService.updateProductModel(productId , modelId , request);
    }
    @DeleteMapping("/{productId}/models/{modelId}")
    public void deleteProductModel(@PathVariable Long productId, @PathVariable Long modelId) {
        productModelService.deleteProductModel(productId , modelId);
    }


}
