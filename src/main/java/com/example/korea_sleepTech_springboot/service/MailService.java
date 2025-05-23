package com.example.korea_sleepTech_springboot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface MailService {
    Mono<ResponseEntity<String>> sendSimpleMessage(String email);
    Mono<ResponseEntity<String>> verifyEmail(String token);
}
