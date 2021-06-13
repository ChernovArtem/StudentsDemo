package ru.artemchernov.studentsdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemchernov.studentsdemo.model.ProgressHandbook;

public interface ProgressHandbookRepository extends JpaRepository<ProgressHandbook, Long> {
}
