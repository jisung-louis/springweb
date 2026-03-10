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
public class EnrollRequestDto {
    private Long enrollId;
    private Boolean status;
    private Long courseId;
    private Long studentId;
    private String createdAt;
    private String updatedAt;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
                .enrollId(enrollId)
                .status(status)
                .build();
    }
}
