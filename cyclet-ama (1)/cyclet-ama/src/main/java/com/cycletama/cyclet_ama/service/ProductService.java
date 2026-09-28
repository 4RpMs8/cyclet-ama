package com.cycletama.cyclet_ama.service;

import java.util.List;

import com.cycletama.cyclet_ama.dto.ProductDTO;
import com.cycletama.cyclet_ama.entity.Product;
import com.cycletama.cyclet_ama.entity.ProductModel;
import com.cycletama.cyclet_ama.exception.ProductNotFoundException;
import com.cycletama.cyclet_ama.mapper.ProductMapper;
import com.cycletama.cyclet_ama.mapper.ProductModelMapper;
import com.cycletama.cyclet_ama.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> GetAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public ProductDTO createProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return productMapper.toDTO(saveProduct);

    }

    public ProductDTO getProductById(Long id) {
        return productMapper.toDTO(productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found")));
    }

    public Product updateProduct(Long Id , Product product) {
        Product existingProduct = productRepository.findById(Id).orElseThrow(() -> new ProductNotFoundException("product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found"));
        productRepository.delete(existingProduct);
    }

}
