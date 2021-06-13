package ru.artemchernov.studentsdemo.service;

import ru.artemchernov.studentsdemo.model.Student;
import java.util.List;

public interface StudentService {

    /**
     *
     * @param id
     * @return
     */
    Student getById(Long id);

    /**
     *
     * @param student
     */
    void save(Student student);

    /**
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     *
     * @return
     */
    List<Student> getAll();
}
