package example.day07.practice7.entity;

import example.day07.practice7.BaseTime;
import example.day07.practice7.dto.StudentDto;
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
@Table(name = "student")
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    private String studentName;

    public StudentDto toDto(){
        return StudentDto.builder()
                .studentId(studentId)
                .studentName(studentName)
                .createdAt(getCreatedAt().toString())
                .updatedAt(getUpdatedAt().toString())
                .build();
    }
}
