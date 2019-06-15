package com.orion.v13.pojo;

import com.orion.v13.entity.TProduct;

import java.io.Serializable;

/**
 * Orion
 */
public class TProductVO implements Serializable{
    private TProduct product;
    private String productDesc;

    public TProduct getProduct() {
        return product;
    }

    public void setProduct(TProduct product) {
        this.product = product;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
