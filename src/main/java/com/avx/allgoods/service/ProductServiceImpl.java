package com.avx.allgoods.service;

import com.avx.allgoods.entity.ImageEntity;
import com.avx.allgoods.entity.ProductEntity;
import com.avx.allgoods.mapper.ImageMapper;
import com.avx.allgoods.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ImageMapper imageMapper;


    public List<ProductEntity> listProduct(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public ProductEntity findByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(null);
    }

    public void saveProduct(ProductEntity productEntity, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
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
        ProductEntity productFromDb = productRepository.save(productEntity);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(productEntity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
