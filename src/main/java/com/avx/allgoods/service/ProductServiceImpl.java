package com.avx.allgoods.service;

import com.avx.allgoods.entity.ProductEntity;
import com.avx.allgoods.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public List<ProductEntity> listProduct(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public ProductEntity findByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(null);
    }

    public void saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
