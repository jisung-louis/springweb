package example.day06.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 이하 롬복
@AllArgsConstructor
@Data
@Builder
@Entity // 이하 영속성
@Table(name = "goods") // 생략시 클래스명으로 자동 생성
public class GoodsEntity extends BaseTime {
    @Id // JPA는 엔티티 내 1개 이상의 Primary Key를 필수로 한다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer gno; // 제품 번호
    @Column(name = "제품명", nullable = false, length = 100)
    private String gname; // 제품명
    @Column(columnDefinition = "varchar(100) default '제품설명' not null")
    private String gdesc; // 제품 설명
    // @Column // 생략 가능시 : 자바의 타입 --> SQL 타입, 자바의 변수명 --> SQL 필드명
    private Integer gprice; // 제품 가격


    // ENTITY --> DTO 변환 함수
    // Service 같은 사용처에서 변환하는 함수를 만들어도 되지만, 이건 많이 쓰는 함수들이라 그냥 Entity파일, DTO파일에 만들어놔도 된다.
    public GoodsDto toDto(){
        return GoodsDto.builder()
                .gno(gno) // this 생략 (생략해도 똑같음)
                .gname(gname)
                .gprice(gprice)
                .gdesc(gdesc)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
/*
    @Id : primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) : auto_increment
    @Column( )
        name = "필드명"           , 기본값은 자바필드명
        nullable = false        , 기본값은 true
        length = 길이            , 기본값은 255
        unique = true           , 기본값은 false
        insertable = true,      , 기본값은 true, insert 할 때 적용여부
        updatable = true        , 기본값은 true, update 할 때 적용여부
        columnDefinition = "SQL"

    레코드 생성(회원가입/등록일/주문일/작성일 등등)날짜 / 수정날짜
 */