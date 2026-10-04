package com.cycletama.cyclet_ama.service;

import java.math.BigDecimal;
import java.util.List;

import com.cycletama.cyclet_ama.controller.ProductModelController;
import com.cycletama.cyclet_ama.dto.ProductModelDTO;
import com.cycletama.cyclet_ama.entity.Product;
import com.cycletama.cyclet_ama.entity.ProductModel;
import com.cycletama.cyclet_ama.exception.ProductModelNotFoundException;
import com.cycletama.cyclet_ama.exception.ProductNotFoundException;
import com.cycletama.cyclet_ama.mapper.ProductModelMapper;
import com.cycletama.cyclet_ama.repository.ProductModelRepository;
import com.cycletama.cyclet_ama.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.cycletama.cyclet_ama.dto.CreatProductModelRequest;

@Service
public class ProductModelService {
    private final ProductModelRepository productModelRepository;
    private final ProductRepository productRepository;
    private final ProductModelMapper productModelMapper;
    public ProductModelService(ProductModelRepository productModelRepository , ProductRepository productRepository, ProductModelMapper productModelMapper) {
        this.productModelRepository = productModelRepository;
        this.productRepository = productRepository;
        this.productModelMapper = productModelMapper;
    }

    public List<ProductModel> getAllProductModels() {
        return productModelRepository.findAll();
    }

    public List<ProductModelDTO> getModelsByProductId(Long productId) {
        return productModelRepository.findByProductId(productId)
                .stream()
                .map(productModelMapper::toDTO)
                .toList();
    }

    public ProductModelDTO createProductModel(Long productId , CreatProductModelRequest request) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found"));
        ProductModel productModel = new ProductModel();
        productModel.setModel(request.getModel());
        productModel.setProductCode(request.getProductCode());
        productModel.setPricePerCarton(request.getPricePerCarton());
        productModel.setStock(request.getStock());
        productModel.setPricePerCarton(request.getPricePerCarton());
        productModel.setStatus(request.getStatus());
        productModel.setProduct(product);
        ProductModel savedProductModel = productModelRepository.save(productModel);
        return productModelMapper.toDTO(savedProductModel);
    }

    public ProductModelDTO updateProductModel(Long productId , Long modelId , CreatProductModelRequest request) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found"));
        ProductModel productModel = productModelRepository.findById(modelId).orElseThrow(() -> new ProductModelNotFoundException("product model not found"));
        if(!productModel.getProduct().getId().equals(product.getId())) {
            throw new ProductModelNotFoundException("product model does not belong to this product");
        }
        productModel.setModel(request.getModel());
        productModel.setProductCode(request.getProductCode());
        productModel.setPricePerCarton(request.getPricePerCarton());
        productModel.setStock(request.getStock());
        productModel.setPiecesPerCarton(request.getPiecesPerCarton());
        productModel.setStatus(request.getStatus());
        ProductModel savedProductModel = productModelRepository.save(productModel);
        return productModelMapper.toDTO(savedProductModel);

    }

    public void deleteProductModel(Long productId , Long modelId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found"));
        ProductModel productModel = productModelRepository.findById(modelId).orElseThrow(() -> new ProductModelNotFoundException("product model not found"));
        if(!productModel.getProduct().getId().equals(product.getId())) {
            throw new ProductModelNotFoundException("product model does not belong to this product");
        }
        productModelRepository.delete(productModel);
    }


}
