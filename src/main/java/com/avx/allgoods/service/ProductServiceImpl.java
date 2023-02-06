package com.avx.allgoods.service;

import com.avx.allgoods.entity.ImageEntity;
import com.avx.allgoods.entity.ProductEntity;
import com.avx.allgoods.entity.UserEntity;
import com.avx.allgoods.mapper.ImageMapper;
import com.avx.allgoods.repository.ProductRepository;
import com.avx.allgoods.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ImageMapper imageMapper;

    private final UserRepository userRepository;


    public List<ProductEntity> listProduct(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public ProductEntity findByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(null);
    }

    public void saveProduct(Principal principal, ProductEntity productEntity, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        productEntity.setUser(getUserByPrincipal(principal));
        ImageEntity image1;
        ImageEntity image2;
        ImageEntity image3;

        if (file1.getSize() != 0) {
            image1 = imageMapper.toImageEntity(file1);
            image1.setPreviewImage(true);
            productEntity.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = imageMapper.toImageEntity(file2);
            productEntity.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = imageMapper.toImageEntity(file3);
            productEntity.addImageToProduct(image3);
        }
        log.info("Saving new Product. Title: {}; Author: {}", productEntity.getTitle(), productEntity.getUser().getEmail());
        ProductEntity productFromDb = productRepository.save(productEntity);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(productEntity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public UserEntity getUserByPrincipal(Principal principal) {
        if (principal == null) return new UserEntity();
        return userRepository.findByEmail(principal.getName());
    }

}
