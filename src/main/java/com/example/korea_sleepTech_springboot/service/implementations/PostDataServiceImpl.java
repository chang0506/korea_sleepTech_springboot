package com.example.korea_sleepTech_springboot.service.implementations;

import com.example.korea_sleepTech_springboot.common.ResponseMessage;
import com.example.korea_sleepTech_springboot.dto.file.PostRequestDto;
import com.example.korea_sleepTech_springboot.dto.file.PostResponseDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.entity.Post;
import com.example.korea_sleepTech_springboot.repository.PostDataRepositoy;
import com.example.korea_sleepTech_springboot.repository.UploadFileRepository;
import com.example.korea_sleepTech_springboot.service.PostDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostDataServiceImpl implements PostDataService {
    private final PostDataRepositoy postDataRepositoy;
    private final UploadFileRepository uploadFileRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public ResponseDto<PostResponseDto> createPost(PostRequestDto dto, MultipartFile file) {
        PostResponseDto data = null;

        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getCocntent());

        post = postDataRepositoy.save(post);

        if (file != null && !file.isEmpty()) {
            // 업로드 된 파일이 존재하고 비어있지 않다면
            saveFile(file, post.getId(), "POST");
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 실제 파일을 저장하고 DB에 메타데이터를 저장하는 메서드
    private void saveFile(MultipartFile file, Long targetId, String type) {
        File dir = new File(uploadDir); // 업로드 디렉토리 객체 생성
        if(!dir.exists()) dir.mkdirs(); // 디렉토리가 없으면 생성 (mk: make, dirs: directory 폴더)

        String original = file.getOriginalFilename(); // 원본 파일명
        String uuidName = UUID.randomUUID() + "_" + original; // UUID를 활용한 유일한 파일명 생성

    }
}
