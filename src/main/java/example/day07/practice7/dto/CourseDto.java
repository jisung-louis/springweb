package example.day07.practice7.dto;

import example.day07.practice7.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseDto {
    private Long courseId;
    private String courseName;
    private String createdAt;
    private String updatedAt;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .courseId(courseId)
                .courseName(courseName)
                .build();
    }
}
