package com.avx.allgoods.mapper;

import com.avx.allgoods.entity.ImageEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageMapper {

    public ImageEntity toImageEntity(MultipartFile file) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
