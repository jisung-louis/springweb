# [Spring 주요 어노테이션]
#### 1. ```@SpringBootApplication``` : 스프링부트 환경 설정
#### 2. ```@ComponentScan``` : 동일/하위 패키지 내 컴포넌트들을 스캔하여 빈 등록
#### 3. ```@Component``` : 빈 등록
1. ```@Controller``` : HTTP 요청 과 응답 처리 + @Component 포함 , SPRING MVC에서 통신 담당
2. ```@Service``` : SPRING MVC에서 비즈니스로직(DB처리 외 핵심코드) 담당
3. ```@Repository``` : SPRING MVC에서 퍼시스턴스(데이터베이스 데이터처리) 담당
#### 4. ```@Autowired``` : 빈 주입
#### 5. ```@RestController``` : HTTP Content-Type 처리 + @ResponseBody + @Controller 포함
1. ```@ResponseBody``` : HTTP Content-Type 처리
#### 6. ```@RequestMapping``` : HTTP URL 매핑 , 주로 클래스 위에 작성시 공통URL 정의
1. ```@GetMapping``` : HTTP 통신의 Get 방식의 요청 매핑
2. ```@PostMapping``` : HTTP 통신의 Post 방식의 요청 매핑
3. ```@PutMapping``` : HTTP 통신의 Put 방식의 요청 매핑
4. ```@DeleteMapping``` : HTTP 통신의 Delete 방식의 요청 매핑
#### 7. ```@RequestParam``` : HTTP 쿼리스트링(URL?매개변수=값) 매개변수 매핑
#### 8. ```@RequestBody``` : HTTP BODY(본문) 매핑 , POST/PUT

# [롬복 주요 어노테이션]
#### 1. ```@NoArgsConstructor``` : 인수 없는 생성자 자동 생성
#### 2. ```@AllArgsConstructor``` : 모둔 인수 있는 생성자 자동 생성
#### 3. ```@RequiredArgsConstructor``` : Final 멤버 변수 있는 생성자 자동 생성
#### 4. ```@Getter``` : 멤버변수들의 get 메소드 자동 생성
#### 5. ```@Setter``` : 멤버변수들의 set 메소드 자동 생성
#### 6. ```@ToString``` : 객체 주소값 대신에 멤버변수값 반환, 오버라이딩 자동 생성
#### 7. ```@Data``` : @Getter + @Setter + @ToString + @RequiredArgsConstructor
#### 8. ```@Builder``` : 빌더패턴 ( (new) 생성자 대신에 메소드로 객체 생성 방법 )