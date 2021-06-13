package ru.artemchernov.studentsdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemchernov.studentsdemo.model.ProgressHandbook;
import ru.artemchernov.studentsdemo.repository.ProgressHandbookRepository;
import ru.artemchernov.studentsdemo.service.ProgressHandbookService;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressHandbookServiceImpl implements ProgressHandbookService {

    @Autowired
    ProgressHandbookRepository progressHandbookRepository;

    @Override
    public void save(ProgressHandbook progressHandbook) {
        progressHandbookRepository.save(progressHandbook);
    }

    @Override
    public ProgressHandbook getById(Long id) {
        Optional<ProgressHandbook> optionalProgressHandbook = progressHandbookRepository.findById(id);
        return optionalProgressHandbook.get();
    }

    @Override
    public List<ProgressHandbook> getAll() {
        return progressHandbookRepository.findAll();
    }
}
