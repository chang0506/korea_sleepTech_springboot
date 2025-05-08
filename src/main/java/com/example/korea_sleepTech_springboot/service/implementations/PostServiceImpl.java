package com.example.korea_sleepTech_springboot.service.implementations;

import com.example.korea_sleepTech_springboot.common.ResponseMessage;
import com.example.korea_sleepTech_springboot.dto.request.PostCreateReqDto;
import com.example.korea_sleepTech_springboot.dto.request.PostUpdateReqDto;
import com.example.korea_sleepTech_springboot.dto.response.CommentResDto;
import com.example.korea_sleepTech_springboot.dto.response.PostDetailResDto;
import com.example.korea_sleepTech_springboot.dto.response.PostListResDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.entity.D_Post;
import com.example.korea_sleepTech_springboot.repository.PostRepository;
import com.example.korea_sleepTech_springboot.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public ResponseDto<PostDetailResDto> createPost(PostCreateReqDto dto) {
        PostDetailResDto responseDto;
        D_Post newPost = D_Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();
        D_Post saved = postRepository.save(newPost);

        responseDto = PostDetailResDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .content(saved.getContent())
                .author(saved.getAuthor())
                .build();

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto<PostDetailResDto> getPostById(Long id) {
        PostDetailResDto responseDto = null;

        D_Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessage.NOT_EXISTS_POST + id));

        List<CommentResDto> comments = post.getComments().stream()
                .map(comment -> CommentResDto.builder()
                        .id(comment.getId())
                        .postId(comment.getPost().getId())
                        .content(comment.getContent())
                        .commenter(comment.getCommenter())
                        .build())
                .collect((Collectors.toList()));

        responseDto = PostDetailResDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .comments(comments) // comment 테이블에서 데이터를 찾아 CommentResDto 형식으로 변환
                .build();
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto<List<PostListResDto>> getAllPosts() {
        List<PostListResDto> responsDto = null;

        List<D_Post> posts = postRepository.findAll();

        responsDto = posts.stream()
                .map(post -> PostListResDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .author(post.getAuthor())
                        .build()).collect(Collectors.toList());

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responsDto);
    }

    @Override
    @Transactional
    public ResponseDto<PostDetailResDto> updatePost(Long id, PostUpdateReqDto dto) {
        PostDetailResDto responseDto = null;

        D_Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessage.NOT_EXISTS_POST + id));

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        D_Post updatedPost = postRepository.save(post);

        responseDto = PostDetailResDto.builder()
                .id(updatedPost.getId())
                .title(updatedPost.getTitle())
                .content(updatedPost.getContent())
                .author(updatedPost.getAuthor())
                .comments(updatedPost.getComments().stream().map(
                        comment -> CommentResDto.builder()
                                .id(comment.getId())
                                .postId(comment.getPost().getId())
                                .content(comment.getContent())
                                .commenter(comment.getCommenter())
                                .build()
                ).collect(Collectors.toList()))
                .build();

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,responseDto);
    }

    @Override
    @Transactional
    public ResponseDto<Void> deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            // .existsById(PK값)
            // : 존재하면 true, 존재하지 않으면 false 반환
            throw new EntityNotFoundException(ResponseMessage.NOT_EXISTS_POST + id);
        }

        postRepository.deleteById(id);
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,null);
    }
}
