package example.day07.practice7.entity;

import example.day07.practice7.BaseTime;
import example.day07.practice7.dto.CourseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "course")
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(nullable = false)
    private String courseName;

    public CourseDto toDto(){
        return CourseDto.builder()
                .courseId(courseId)
                .courseName(courseName)
                .createdAt(getCreatedAt().toString())
                .updatedAt(getUpdatedAt().toString())
                .build();
    }
}
