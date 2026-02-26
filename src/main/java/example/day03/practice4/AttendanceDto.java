package example.day03.practice4;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
    private int ano;
    String studentName;
    String date;
    String status;
}
