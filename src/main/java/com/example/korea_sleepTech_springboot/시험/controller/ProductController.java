package com.example.korea_sleepTech_springboot.시험.controller;

import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.시험.Service.ProductService;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductCreateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductUpdateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDto<ProductResponseDto>> createProduct(@RequestBody ProductCreateRequestDto dto) {
        try {
            ResponseDto<ProductResponseDto> product = productService.createProduct(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<ProductResponseDto>>> getAllProduct() {
        ResponseDto<List<ProductResponseDto>> responseDto = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<ProductResponseDto>> getProductById(@PathVariable Long id) {
        try {
            ResponseDto<ProductResponseDto> responseDto = productService.getProductById(id);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto dto) {
        try {
            ProductResponseDto responseDto = productService.updateProduct(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
    }
}
