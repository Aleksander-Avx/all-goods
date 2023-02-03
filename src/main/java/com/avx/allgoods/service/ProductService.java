package com.avx.allgoods.service;

import com.avx.allgoods.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> listProduct(String title);

    ProductEntity findByIdProduct(Long id);
    void saveProduct(ProductEntity productEntity);

    void deleteProduct(Long id);

}
