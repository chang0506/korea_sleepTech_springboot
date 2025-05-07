package com.example.korea_sleepTech_springboot.controller;

import com.example.korea_sleepTech_springboot.common.ApiMappingPattern;
import com.example.korea_sleepTech_springboot.dto.request.PostCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.PostDetailResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.POST_API)
@RequiredArgsConstructor // 생성자 주입
public class PostController {

    // @Autowired // 의존성을 자동 주입 - 필드 주입
    private final PostService postService;

    // 1) 게시글 작성
    @PostMapping
    // @Valid
    // : DTO 객체에 대한 검증을 수행하는 애너테이션
    // : 사용자가 클라이언트로부터 전달한 데이터가 미리 정의된 규칙에 맞는지 확인
    // - DTO 내에서 정의된 규칙에 맞지 않으면 에러 발생 (
    public ResponseEntity<ResponseDto<PostDetailResDto>> createPost(@Valid @RequestBody PostCreateReqDto dto) {
        ResponseDto<PostDetailResDto> post = postService.createPost(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
