package com.cycletama.cyclet_ama.service;

import java.util.List;

import com.cycletama.cyclet_ama.dto.ProductDTO;
import com.cycletama.cyclet_ama.entity.Category;
import com.cycletama.cyclet_ama.entity.Product;
import com.cycletama.cyclet_ama.entity.ProductModel;
import com.cycletama.cyclet_ama.exception.ProductNotFoundException;
import com.cycletama.cyclet_ama.mapper.ProductMapper;
import com.cycletama.cyclet_ama.mapper.ProductModelMapper;
import com.cycletama.cyclet_ama.repository.CategoryRepository;
import com.cycletama.cyclet_ama.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    public final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository, ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
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

    public void addCategoryToProduct(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found"));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ProductNotFoundException("category not found"));
        product.getCategories().add(category);
        productRepository.save(product);
    }

    public void removeCategoryFromProduct(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found"));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ProductNotFoundException("category not found"));
        product.getCategories().remove(category);
        productRepository.save(product);
    }


}
