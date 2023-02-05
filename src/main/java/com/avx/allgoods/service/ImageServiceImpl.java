package com.avx.allgoods.service;

import com.avx.allgoods.entity.ImageEntity;
import com.avx.allgoods.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;


    public ImageEntity findByIdImage(Long id) {
        return imageRepository.findById(id).orElseThrow(null);
    }

}
