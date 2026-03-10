package example.day07.practice7.service;

import example.day07.practice7.dto.EnrollRequestDto;
import example.day07.practice7.dto.EnrollResponseDto;
import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import example.day07.practice7.repository.CourseRepository;
import example.day07.practice7.repository.EnrollRepository;
import example.day07.practice7.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EnrollService {
    private final EnrollRepository enrollRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public boolean addEnroll(EnrollRequestDto enrollRequestDto){
        Optional<CourseEntity> course = courseRepository.findById(enrollRequestDto.getCourseId());
        Optional<StudentEntity> student = studentRepository.findById(enrollRequestDto.getStudentId());
        if(course.isEmpty() || student.isEmpty()) {
            return false;
        }
        EnrollEntity enroll = EnrollEntity.builder()
                .enrollId(enrollRequestDto.getEnrollId())
                .status(enrollRequestDto.getStatus())
                .course(course.get())
                .student(student.get())
                .build();
        EnrollEntity save = enrollRepository.save(enroll);
        return save.getEnrollId() >= 1;

    }

    public List<EnrollResponseDto> getEnrolls(){
        List<EnrollResponseDto> list = new ArrayList<>();
        List<EnrollEntity> all = enrollRepository.findAll();

        all.forEach(enroll -> {
            EnrollResponseDto dto = enroll.toDto();
            list.add(dto);
        });
        return list;
    }
}
