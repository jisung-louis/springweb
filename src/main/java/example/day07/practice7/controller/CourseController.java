package example.day07.practice7.controller;

import example.day07.practice7.dto.CourseDto;
import example.day07.practice7.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public boolean addCourse(@RequestBody CourseDto courseDto){
        return courseService.addCourse(courseDto);
    }
}
