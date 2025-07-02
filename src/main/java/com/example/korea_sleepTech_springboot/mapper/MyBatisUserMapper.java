package com.example.korea_sleepTech_springboot.mapper;

import com.example.korea_sleepTech_springboot.entity.MyBatisUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBatisUserMapper {
    // MyBatisUser 중에서 이메일이 @gmail.com 으로 끝나는 유저들을 전체 조회
    List<MyBatisUserMapper> findAllWithGmailDomain();

    // 사용자 Email을 사용하여 정보 단건 조회
    MyBatisUser findByEmail(String email);
}
