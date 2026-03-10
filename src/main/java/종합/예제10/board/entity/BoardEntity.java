package 종합.예제10.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.BaseTime;
import 종합.예제10.board.dto.BoardDto;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(nullable = false)
    private String btitle;

    @Column(nullable = false)
    @Lob // Large OBject ; MySQL에서 LONGTEXT를 의미한다. columnDefinition을 활용한 커스텀 쿼리를 사용하려 했는데, 그건 MySQL에 의존적이기 때문에 이걸로 바꿈
    private String bcontent;
    @Column(nullable = true, length = 30)
    private String bwriter;

    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bwriter(bwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
