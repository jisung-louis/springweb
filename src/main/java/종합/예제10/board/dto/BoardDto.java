package 종합.예제10.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.BoardEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {
    private Long bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String createDate;
    private String updateDate;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bwriter(bwriter)
                .build();
    }
}
