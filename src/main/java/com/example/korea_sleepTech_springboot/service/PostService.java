package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.request.PostCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.PostDetailResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    public ResponseDto<PostDetailResDto> createPost(@Valid PostCreateReqDto dto);
}