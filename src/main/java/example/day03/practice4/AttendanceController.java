package example.day03.practice4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @PostMapping
    public boolean attendancePost(@RequestBody AttendanceDto attendanceDto){
        System.out.println(attendanceDto);
        return true;
    }

    @GetMapping
    public List<AttendanceDto> attendanceGetAll(){
        List<AttendanceDto> list = new ArrayList<>();
        return list;
    }

    @GetMapping("/detail")
    public AttendanceDto attendanceGetOne(){
        return new AttendanceDto();
    }

    @DeleteMapping
    public boolean attendanceDelete(@RequestParam int ano){
        return true;
    }

    @PutMapping
    public boolean attendanceUpdate(@RequestBody AttendanceDto attendanceDto){
        return true;
    }
}
