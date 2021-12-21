package com.julucin.hrworkers.services.impl;

import com.julucin.hrworkers.entities.WorkerEntity;
import com.julucin.hrworkers.exceptions.NullIdException;
import com.julucin.hrworkers.exceptions.thrower.WorkerExceptionsThrower;
import com.julucin.hrworkers.repositories.WorkersRepository;
import com.julucin.hrworkers.services.WorkersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkersServiceImpl implements WorkersService {

    private final WorkersRepository workersRepository;

    @Override
    public List<WorkerEntity> retrieveAll() {
        return this.workersRepository.findAll();
    }

    @Override
    public Page<WorkerEntity> retrievePageOf(Integer pageNumber, Integer pageSize) {
        return this.workersRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Optional<WorkerEntity> retrieveBy(Long id) {
        return this.workersRepository.findById(id);
    }

    @Override
    public WorkerEntity saveNew(WorkerEntity newEntity) {
        log.info("Saving new instance of worker. Name: ".concat(newEntity.getName()));
        return this.workersRepository.save(newEntity);
    }

    @Override
    public void save(WorkerEntity entity) {
        log.info("Updating instance of worker. Id: ".concat(entity.getId().toString()));
        var id = ofNullable(entity.getId()).orElseThrow(NullIdException::new);
        var previouslySavedInstance = this.retrieveBy(id);
        previouslySavedInstance.ifPresentOrElse(this.workersRepository::save, () -> WorkerExceptionsThrower.throwInstanceDoesNotExistException(id));
    }

    @Override
    public void deleteBy(Long id) {
        log.info("Deleting instance of worker. Id: ".concat(id.toString()));
        var previouslySavedInstance = this.retrieveBy(id);
        if (previouslySavedInstance.isPresent())
            this.workersRepository.deleteById(id);
        else
            WorkerExceptionsThrower.throwInstanceDoesNotExistException(id);
    }
}
