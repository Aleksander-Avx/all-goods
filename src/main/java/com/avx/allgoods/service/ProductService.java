package com.avx.allgoods.service;

import com.avx.allgoods.entity.ProductEntity;
import com.avx.allgoods.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductService {
    List<ProductEntity> listProduct(String title);

    ProductEntity findByIdProduct(Long id);

    void saveProduct(Principal principal, ProductEntity productEntity, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;

    //    void deleteProduct(UserEntity user, Long id);
    void deleteProduct(Long id);

    UserEntity getUserByPrincipal(Principal principal);
}

