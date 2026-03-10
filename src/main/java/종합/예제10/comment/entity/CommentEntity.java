package 종합.예제10.comment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.BaseTime;
import 종합.예제10.comment.dto.CommentDto;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "comment")
public class CommentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    @Column
    private Long bno;
    @Column(nullable = false)
    private String ccontent;
    @Column(nullable = false)
    private String cwriter;

    public CommentDto toDto(){
        return CommentDto.builder()
                .cno(cno)
                .bno(bno)
                .ccontent(ccontent)
                .cwriter(cwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
