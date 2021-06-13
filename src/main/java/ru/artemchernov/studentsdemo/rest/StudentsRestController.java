package ru.artemchernov.studentsdemo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artemchernov.studentsdemo.model.Student;
import ru.artemchernov.studentsdemo.service.StudentService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
@Tag(name="Взаимодействие со студентами", description="Добавление, удаление и редактирование студента")
public class StudentsRestController {

    @Autowired
    private StudentService studentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Добавление студента", description = "Позволяет добавить студента")
    public ResponseEntity<Student> saveStudent(
            @RequestBody @Valid @Parameter(description = "Сущность добавляемого студента") Student student) {
        HttpHeaders headers = new HttpHeaders();

        this.studentService.save(student);
        return new ResponseEntity<>(student, headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Удаление студента", description = "Позволяет убрать студента")
    public ResponseEntity<Student> deleteStudent(
            @PathVariable("id") @Parameter(description = "Идентификатор удаляемого студента") Long id) {
        Student student = this.studentService.getById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Редактирование студента", description = "Позволяет изменить информацию о студенте")
    public ResponseEntity<Student> updateStudent(
            @RequestBody @Valid @Parameter(description = "Сущность измененного студента") Student student) {
        HttpHeaders headers = new HttpHeaders();

        this.studentService.save(student);
        return new ResponseEntity<>(student, headers, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение одного студента", description = "Получение одного студента по идентификатору")
    public ResponseEntity<Student> getStudent(
            @PathVariable("id") @Parameter(description = "Идентификатор студента") Long studentId) {
        if (studentId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Student student = this.studentService.getById(studentId);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение всех студентов", description = "Получение всех студентов")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = this.studentService.getAll();
        if (allStudents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
}
