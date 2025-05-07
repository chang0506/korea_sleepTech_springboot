package com.example.korea_sleepTech_springboot.시험.Service;

import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductCreateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductUpdateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ProductResponseDto;
import com.example.korea_sleepTech_springboot.시험.entity.Product;
import com.example.korea_sleepTech_springboot.시험.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ResponseDto<ProductResponseDto> createProduct(ProductCreateRequestDto dto) {
        try {
            Product newProduct = new Product(
                    null, dto.getName(), dto.getDescription(), dto.getPrice(), null, null
            );

            Product saveBook = productRepository.save(newProduct);

            ProductResponseDto responseDto = new ProductResponseDto(
                    saveBook.getId(),
                    saveBook.getName(),
                    saveBook.getDescription(),
                    saveBook.getPrice()
            );
            return ResponseDto.setSuccess("상품 추가 완료", responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("상품 등록 중 오류가 발생하였습니다: " + e.getMessage());
        }
    }

    public ResponseDto<List<ProductResponseDto>> getAllProduct() {
        List<ProductResponseDto> responseDto = null;
        try {
            List<Product> products = productRepository.findAll();
            responseDto = products.stream()
                    .map(product -> new ProductResponseDto(
                            product.getId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice()
                    )).collect(Collectors.toList());
            return ResponseDto.setSuccess("전체 조회 성공", responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("조회 실패");
        }
    }

    public ResponseDto<ProductResponseDto> getProductById(Long id) {
        ProductResponseDto responseDto = null;
        try {
            Product products = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 책을 찾을 수 없습니다: " + id));
            responseDto = new ProductResponseDto(
                    products.getId(),
                    products.getName(),
                    products.getDescription(),
                    products.getPrice()
            );
            return ResponseDto.setSuccess("책 조회 완료", responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("조회 실패");
        }
    }

    public ProductResponseDto updateProduct(Long id, ProductUpdateRequestDto dto) {
        ProductResponseDto responseDto = null;
        try {
           Product products = productRepository.findById(id)
                   .orElseThrow(() -> new IllegalArgumentException("해당 id의 책을 찾을 수 없습니다: " + id));
           products.setName(dto.getName());
           products.setDescription(dto.getDescription());
           products.setPrice(dto.getPrice());

           Product updateProduct = productRepository.save(products);

           responseDto = new ProductResponseDto(
                   updateProduct.getId(),
                   updateProduct.getName(),
                   updateProduct.getDescription(),
                   updateProduct.getPrice()
           );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDto;
    }

    public void deleteProduct(Long id) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 책을 찾을 수 없습니다: " + id));
            productRepository.delete(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
