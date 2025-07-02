package com.example.korea_sleepTech_springboot.이론;

/*
 * ==== MyBatis =====
 * : SQL 기반의 Persistence Framework (영속성 프레임워크)
 * : 복잡한 SQL 작성이 자유롭고, 직접 쿼리를 작성하여 실행하는 도구
 *
 * 1. JPA + MyBatis 공통점
 *  - DB 접근 도구 (DB의 데이터를 조작)
 *  - SQL 사용 (다만, 방식이 다름! & CRUD 기능을 제공)
 *  - Java 코드와 DB를 연결 (User 엔티티 클래스 <-> users 테이블)
 *
 * 2. JPA VS MyBatis 차이점
 *  - JPA: 객체 중심 (개발자가 SQL 쿼리를 직접 쓰지 않아도 엔티티(객체)를 분석하여 JPA가 알아서 DB와 소통)
 *  - MyBatis: 쿼리 중심 (개발자가 직접 쿼리를 작성하여 DB와 소통)
 *
 *  +) 설정 및 사용(학습)법의 차이
 *      - JPA) 초기 학습 난이도가 있음, 어노테이션 기반(@Id, @Entity, @GeneratedValue 등, 개발 속도가 빠름
 *      - MyBatis) 초기 학습이 쉬움, XML 또는 어노테이션으로 매핑 파일을 따로 관리, 개발 속도가 느림
 *
 *  +) 유지보수와 확장성
 *      - JPA) 도메인 중심 설계(DDD), 유지보수가 쉬움 / 복잡한 쿼리 작성이 어려움
 *      - MyBatis) 복잡한 SQL 처리에 강함(복잡한 조인(join), 다중 필터링 & 통계 기능) / SQL이 많아지면 유지보수가 어려움
 *
 *  cf) 도메인 중심 설계
 *      - 도메인 간의 상호작용이 설계의 핵심
 *      - 각 도메인은 서로 협력하지만 책임과 역할이 분명한 높은 응집도와 낮은 결합도를 가지는 상태를 지향!
 *
 * 3. 사용 방법
 *  - JPA) 프로젝트가 크고 유지보수가 중요할 때, 객체 지향 설계와 도메인 중심 개발 목표일 경우
 *  - MyBatis) 복잡하고 최적화된 SQL이 중요한 경우
 */

public class T_MyBatis {
}
