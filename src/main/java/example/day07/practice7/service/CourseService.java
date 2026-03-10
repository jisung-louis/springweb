package example.day07.practice7.service;

import example.day07.practice7.dto.CourseDto;
import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public boolean addCourse(CourseDto courseDto){
        CourseEntity entity = courseDto.toEntity();
        CourseEntity save = courseRepository.save(entity);
        return save.getCourseId() >= 1;
    }
}
