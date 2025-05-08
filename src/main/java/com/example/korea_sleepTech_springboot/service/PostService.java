package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.request.PostCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.PostDetailResDto;
import com.example.korea_sleepTech_springboot.dto.response.PostListResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public ResponseDto<PostDetailResDto> createPost(@Valid PostCreateReqDto dto);

    ResponseDto<PostDetailResDto> getPostById(Long id);

    ResponseDto<List<PostListResDto>> getAllPosts();
}