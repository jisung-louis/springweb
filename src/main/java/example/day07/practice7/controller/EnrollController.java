package example.day07.practice7.controller;

import example.day07.practice7.dto.EnrollRequestDto;
import example.day07.practice7.dto.EnrollResponseDto;
import example.day07.practice7.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enroll")
@RequiredArgsConstructor
public class EnrollController {
    private final EnrollService enrollService;

    @PostMapping
    public boolean addEnroll(@RequestBody EnrollRequestDto enrollRequestDto){
        return enrollService.addEnroll(enrollRequestDto);
    }

    @GetMapping
    public List<EnrollResponseDto> getEnrolls(){
        return enrollService.getEnrolls();
    }

    @GetMapping("/detail")
    public EnrollResponseDto getEnroll(@RequestParam Long enrollId){
        return enrollService.getEnroll(enrollId);
    }
}
