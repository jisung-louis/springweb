package 종합.예제10.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.comment.entity.CommentEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommentDto {
    private Long cno;
    private Long bno;
    private String ccontent;
    private String cwriter;
    private String createDate;
    private String updateDate;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
                .cno(cno)
                .bno(bno)
                .ccontent(ccontent)
                .cwriter(cwriter)
                .build();
    }
}
