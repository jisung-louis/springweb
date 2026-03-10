package example.day07.practice7.dto;

import example.day07.practice7.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDto {
    private Long studentId;
    private String studentName;
    private String createdAt;
    private String updatedAt;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
                .studentId(studentId)
                .studentName(studentName)
                .build();
    }
}
