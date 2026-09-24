package com.cycletama.cyclet_ama.service;

import java.util.List;
import com.cycletama.cyclet_ama.entity.Product;
import com.cycletama.cyclet_ama.exception.ProductNotFoundException;
import com.cycletama.cyclet_ama.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> GetAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found"));
    }

    public Product updateProduct(Long Id , Product product) {
        Product existingProduct = productRepository.findById(Id).orElseThrow(() -> new ProductNotFoundException("product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        return productRepository.save(existingProduct);
    }
}
