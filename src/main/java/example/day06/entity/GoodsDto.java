package example.day06.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GoodsDto {
    private Integer gno;
    private String gname;
    private String gdesc;
    private Integer gprice;
    // + baseTime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수
    // Service 같은 사용처에서 변환하는 함수를 만들어도 되지만, 이건 많이 쓰는 함수들이라 그냥 Entity파일, DTO파일에 만들어놔도 된다.
    public GoodsEntity toEntity(){
        // 빌더 패턴이란? new 생성자가 아닌 함수로 객체 생성
        // this란? 해당 메소드/함수 실행한 객체
        return GoodsEntity.builder() // 빌더 시작
                .gno(this.gno)
                .gname(this.gname)
                .gprice(this.gprice)
                .gdesc(this.gdesc)
                .build(); // 빌더 끝
    }
}
