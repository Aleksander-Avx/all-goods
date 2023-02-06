package com.avx.allgoods.service;

import com.avx.allgoods.entity.UserEntity;
import com.avx.allgoods.entity.enums.Role;
import com.avx.allgoods.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createUser(UserEntity userEntity) {
        String email = userEntity.getEmail();
        if(userRepository.findByEmail(email) != null) return false;
        userEntity.setActive(true);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.getRoles().add(Role.ROLE_USER);
        userRepository.save(userEntity);
        return true;
    }
}
