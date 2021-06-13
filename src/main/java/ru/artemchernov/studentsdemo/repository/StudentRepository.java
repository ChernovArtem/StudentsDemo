package ru.artemchernov.studentsdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemchernov.studentsdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
