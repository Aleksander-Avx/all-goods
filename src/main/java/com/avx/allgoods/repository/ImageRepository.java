package com.avx.allgoods.repository;

import com.avx.allgoods.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository <ImageEntity, Long > {

}
