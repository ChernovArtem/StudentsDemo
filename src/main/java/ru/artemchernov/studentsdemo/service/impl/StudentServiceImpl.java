package ru.artemchernov.studentsdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemchernov.studentsdemo.model.Student;
import ru.artemchernov.studentsdemo.repository.StudentRepository;
import ru.artemchernov.studentsdemo.service.StudentService;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.get();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
