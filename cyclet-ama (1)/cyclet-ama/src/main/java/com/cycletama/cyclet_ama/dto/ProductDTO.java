package com.cycletama.cyclet_ama.dto;

import java.util.Set;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Set<CategoryDTO> categories ;
    private Set<ProductModelDTO> models;

    public Set<ProductModelDTO> getModels() {
        return models;
    }

    public void setModels(Set<ProductModelDTO> models) {
        this.models = models;
    }

    public Long getId() {
        return id;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
