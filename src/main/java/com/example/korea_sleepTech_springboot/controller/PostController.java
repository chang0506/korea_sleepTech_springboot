package com.example.korea_sleepTech_springboot.controller;

import com.example.korea_sleepTech_springboot.common.ApiMappingPattern;
import com.example.korea_sleepTech_springboot.dto.request.PostCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.request.PostUpdateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.PostDetailResDto;
import com.example.korea_sleepTech_springboot.dto.response.PostListResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 2) 단건 조회 (댓글 포함)
    // @Param: 조회하고자 하는 댓글을 지정하는 고유 id - PathVariable(경로 변수)
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<PostDetailResDto>> getPostById(@PathVariable Long id) {
        ResponseDto<PostDetailResDto> post = postService.getPostById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    // 3) 전체 조회 (댓글 제외)
    @GetMapping
    public ResponseEntity<ResponseDto<List<PostListResDto>>> getAllPosts() {
        ResponseDto<List<PostListResDto>> posts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    // 4) 게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<PostDetailResDto>> updatePost(@PathVariable Long id, @Valid @RequestBody PostUpdateReqDto dto) {
        ResponseDto<PostDetailResDto> post = postService.updatePost(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    // 5) 게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deletePost(@PathVariable Long id) {
        ResponseDto<Void> post = postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
