package com.cycletama.cyclet_ama.dto;

import java.math.BigDecimal;

public class CreatProductModelRequest {

    private String model;
    private String productCode;
    private BigDecimal pricePerCarton;
    private Integer stock;
    private Integer piecesPerCarton;
    private String status;
    private Boolean requestQuote;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPricePerCarton() {
        return pricePerCarton;
    }

    public void setPricePerCarton(BigDecimal pricePerCarton) {
        this.pricePerCarton = pricePerCarton;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPiecesPerCarton() {
        return piecesPerCarton;
    }

    public void setPiecesPerCarton(Integer piecesPerCarton) {
        this.piecesPerCarton = piecesPerCarton;
    }

    public Boolean getRequestQuote() {
        return requestQuote;
    }

    public void setRequestQuote(Boolean requestQuote) {
        this.requestQuote = requestQuote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
