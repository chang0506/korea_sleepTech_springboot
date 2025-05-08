package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.request.CommentCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.request.CommentUpdateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.CommentResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    ResponseDto<CommentResDto> createComment(@Valid CommentCreateReqDto dto);

    ResponseDto<CommentResDto> updateComment(@Valid CommentUpdateReqDto dto);
}
