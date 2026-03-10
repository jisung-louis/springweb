package 종합.예제9.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor      // 매개변수 없는 생성자 자동 생성
@AllArgsConstructor     // 전체 매개변수 생성자 자동 생성
@Data                   // setter + getter + toString + RequiredArgsConstructor(final 멤버변수 생성자)
public class BoardDto {
    // 멤버변수 : 데이터베이스의 속성명 과 일치 , +기능에 따라 추가
    private Integer bno;
    private String bcontent;
    private String bwriter;
    private String bdate;
}