package example.day07.practice7.entity;

import example.day07.practice7.BaseTime;
import example.day07.practice7.dto.EnrollRequestDto;
import example.day07.practice7.dto.EnrollResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "enroll")
public class EnrollEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollId;
    @Column(nullable = false)
    @ColumnDefault("true")
    private Boolean status;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private CourseEntity course;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private StudentEntity student;

    public EnrollResponseDto toDto(){
        return EnrollResponseDto.builder()
                .enrollId(enrollId)
                .status(status)
                .course(course.toDto())
                .student(student.toDto())
                .createdAt(getCreatedAt().toString())
                .updatedAt(getUpdatedAt().toString())
                .build();
    }
}
