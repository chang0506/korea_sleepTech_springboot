package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.request.CommentCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.request.CommentUpdateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.CommentResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    ResponseDto<CommentResDto> createComment(Long postId, @Valid CommentCreateReqDto dto);

    ResponseDto<CommentResDto> updateComment(Long postId, Long commentId, @Valid CommentUpdateReqDto dto);

    ResponseDto<Void> deleteComment(Long postId, Long commentId);
}
