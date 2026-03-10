package example.day07.practice7.service;

import example.day07.practice7.dto.StudentDto;
import example.day07.practice7.entity.StudentEntity;
import example.day07.practice7.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public boolean addStudent(StudentDto studentDto){
        StudentEntity entity = studentDto.toEntity();
        StudentEntity save = studentRepository.save(entity);
        return save.getStudentId() >= 1;
    }
}
