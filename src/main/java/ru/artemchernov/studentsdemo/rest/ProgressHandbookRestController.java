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
import ru.artemchernov.studentsdemo.model.ProgressHandbook;
import ru.artemchernov.studentsdemo.service.ProgressHandbookService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/progresshandbook/")
@Tag(name="Взаимодействие со справочником успеваемость", description="Редактирование справочника успеваемости")
public class ProgressHandbookRestController {

    @Autowired
    private ProgressHandbookService progressHandbookService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Редактирование справочника", description = "Позволяет изменить информацию об успеваемости")
    public ResponseEntity<ProgressHandbook> updateProgressHandbook(
            @RequestBody @Valid @Parameter(description = "Сущность измененного справочника") ProgressHandbook progressHandbook) {
        HttpHeaders headers = new HttpHeaders();

        this.progressHandbookService.save(progressHandbook);
        return new ResponseEntity<>(progressHandbook, headers, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение одного значения", description = "Получение одного значения успеваемости из справочника")
    public ResponseEntity<ProgressHandbook> getProgressHandbook(
            @PathVariable("id") @Parameter(description = "Идентификатор справочника") Long progressHandbookId) {
        if (progressHandbookId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ProgressHandbook progressHandbook = this.progressHandbookService.getById(progressHandbookId);
        if (progressHandbook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(progressHandbook, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение всех значений", description = "Получение всех значений успеваемости из справочника")
    public ResponseEntity<List<ProgressHandbook>> getAllProgressHandbooks() {
        List<ProgressHandbook> allProgress = this.progressHandbookService.getAll();

        if (allProgress.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allProgress, HttpStatus.OK);
    }
}
