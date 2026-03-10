package example.day07.practice7.dto;

import example.day07.practice7.entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EnrollResponseDto {
    private Long enrollId;
    private Boolean status;
    private CourseDto course;
    private StudentDto student;
    private String createdAt;
    private String updatedAt;
}
