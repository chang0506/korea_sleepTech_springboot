package com.example.korea_sleepTech_springboot.시험;

public class Test01 {
}

// 1번: 3번
// 2번: 4번
// (1 - 사용자와 개발자 비즈니스로직 사이 요청과 응답을 컨트롤
//  2 - @Controller + @ResponseBody 요청 응답 처리를 위한 애너테이션..?
//  3 - 비즈니스 로직이 작성되는 클래스의 애너테이션)
// 3번: 3번
// 4번: 2번
// 5번: 2번
// 6번: 2번
// 7번: 4번
// (1 - 컨트롤은 사용자와 서비스 간의 요청과 응답을 처리
//  2 - 서비스는 전체 비즈니스 로직을 구현 응답 생성
//  3 - 리포지토리는 실제 데이터를 저장 조회)
// 8번: 3번
// ( 1, 2번은 의존성 주입 방식인 것 확신 3, 4번 헷갈립니다.)
// 9번: 3번
// 10번: 3번
// (1번은 뭔지 모르겠고 2번은 PK같은 변하지 않는 값을 지정할때 쓰는거?? 3번 4번중 요청이라 3번 선택)
// 11번: @Bean..?
// 12번: DELETE
// 13번: @PathVariable
// 14번: @RequestParam
// 15번: 서비스 비즈니스로직 설계
// 16번: 클래스를 jparepository 프레임워크를 활용해 확장해서 메서드를 사용하는 용도..?
// 17번: PUT...?
// 18번: application.properties
// 19번:
// @RestController
// public class Test19 {
//    @GetMapping("/{hello}")
//    public ResponseDto getMessage(@PathVariable Long id, @RequestBody ResponseDto dto){
//        ResponseDto responseDto = Test01Service.createMessage(id, dto);
//        return responseDto;
//    }
//}
// 20번:
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String email;
//}
/// ====================================================
// 각 패키지 별로 구현하는 내용들은 이해하고 있는 상황이고
// 어떤 식으로 작동하는지도 파악이 됐지만
// 세부적인 메서드나 어노테이션은 참고를 해야할 것 같습니다.
// 좀 어려운 부분도 있지만 충분히 할만 합니다

// test01은 개념문제들이 많아서 조금 힘들었던 것 같습니다.