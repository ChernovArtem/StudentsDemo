package ru.artemchernov.studentsdemo.service;

import ru.artemchernov.studentsdemo.model.ProgressHandbook;
import java.util.List;

public interface ProgressHandbookService {

    /**
     *
     * @param student
     */
    void save(ProgressHandbook student);

    /**
     *
     * @param id
     * @return
     */
    ProgressHandbook getById(Long id);

    /**
     *
     * @return
     */
    List<ProgressHandbook> getAll();
}
