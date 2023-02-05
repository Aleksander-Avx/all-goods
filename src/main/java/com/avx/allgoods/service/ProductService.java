package com.avx.allgoods.service;

import com.avx.allgoods.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<ProductEntity> listProduct(String title);

    ProductEntity findByIdProduct(Long id);

    void saveProduct(ProductEntity productEntity, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;

    void deleteProduct(Long id);

}
