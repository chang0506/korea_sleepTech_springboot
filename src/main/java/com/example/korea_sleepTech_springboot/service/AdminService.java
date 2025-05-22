package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.admin.request.PutAuthorityRequestDto;
import com.example.korea_sleepTech_springboot.dto.admin.response.DemoteToAdminResponseDto;
import com.example.korea_sleepTech_springboot.dto.admin.response.PromoteToAdminResponseDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;

public interface AdminService {
    ResponseDto<PromoteToAdminResponseDto> promoteUserToAdmin(PutAuthorityRequestDto dto);

    ResponseDto<DemoteToAdminResponseDto> demoteUserFromAdmin(PutAuthorityRequestDto dto);
}
