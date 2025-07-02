package com.example.korea_sleepTech_springboot.service.implementations;

import com.example.korea_sleepTech_springboot.entity.MyBatisUser;
import com.example.korea_sleepTech_springboot.entity.User;
import com.example.korea_sleepTech_springboot.mapper.MyBatisUserMapper;
import com.example.korea_sleepTech_springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class _MyBatisServiceImpl {
    private final UserRepository userRepository; // JPA
    private final MyBatisUserMapper myBatisUserMapper; // MyBatis

    // Service에서 JPA와 MyBatis 혼용

    // 1) 기본 CRUD - JPA
    public List<User> getUserByJPA() {
        return userRepository.findAll();
    }

    // 2) 필터링 조회 - MyBatis
    public MyBatisUser findByEmilWithMyBatis(String email) {
        return myBatisUserMapper.findByEmail(email);
    }
}
