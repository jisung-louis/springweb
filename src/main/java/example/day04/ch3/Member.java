package example.day04.ch3;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity // 데이터베이스의 테이블의 레코드 와 매핑(연결) 기술 : ORM
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "id", updatable = false) // 필드/속성명 설정, 수정 불가능
    private Long id;

    @Column(name = "name", nullable = false) // 필드/속성명 설정, not null
    private String name;
}
