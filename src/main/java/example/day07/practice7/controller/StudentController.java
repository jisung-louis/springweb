package example.day07.practice7.controller;

import example.day07.practice7.dto.StudentDto;
import example.day07.practice7.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public boolean addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }
}
