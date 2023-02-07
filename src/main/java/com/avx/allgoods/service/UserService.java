package com.avx.allgoods.service;

import com.avx.allgoods.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean createUser(UserEntity userEntity);

    List<UserEntity> list();

    void banUser(Long id);

    void changeUserRoles(UserEntity userEntity, Map<String, String> form );
}
