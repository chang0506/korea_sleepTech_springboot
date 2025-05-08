package com.example.korea_sleepTech_springboot.controller;

import com.example.korea_sleepTech_springboot.common.ApiMappingPattern;
import com.example.korea_sleepTech_springboot.dto.request.CommentCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.request.CommentUpdateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.CommentResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.COMMENT_API)
@RequiredArgsConstructor
public class CommentController {
    // 댓글
    // : CUD

    private final CommentService commentService;

    // 1) 댓글 생성
    @PostMapping
    public ResponseEntity<ResponseDto<CommentResDto>> createComment(@PathVariable Long postId, @Valid @RequestBody CommentCreateReqDto dto) {
        ResponseDto<CommentResDto> responseDto = commentService.createComment(postId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<ResponseDto<CommentResDto>> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @Valid @RequestBody CommentUpdateReqDto dto) {
        ResponseDto<CommentResDto> responseDto = commentService.updateComment(postId, commentId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/{commentOdd}")
    public ResponseEntity<ResponseDto<Void>> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        ResponseDto<Void> responseDto = commentService.deleteComment(postId, commentId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
