package com.julucin.hrworkers.controllers;

import com.julucin.hrworkers.dtos.WorkerDto;
import com.julucin.hrworkers.exceptions.factories.WorkerExceptionsFactory;
import com.julucin.hrworkers.mappers.WorkersMapper;
import com.julucin.hrworkers.services.WorkersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkersController {

    private final WorkersService workersService;

    @GetMapping
    public ResponseEntity<Page<WorkerDto>> retrievePaginated(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        var pageOfWorkers = this.workersService.retrievePageOf(pageNumber, pageSize).map(WorkersMapper::toDto);
        return ResponseEntity.ok(pageOfWorkers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDto> retrieveById(@PathVariable Long id){
        var worker = this.workersService.retrieveBy(id).map(WorkersMapper::toDto)
                .orElseThrow(() -> WorkerExceptionsFactory.makeInstanceDoesNotExistException(id));
        return ResponseEntity.ok(worker);
    }

    @PostMapping
    public ResponseEntity<WorkerDto> saveNewWorker(@RequestBody WorkerDto workerDto, @RequestHeader String host){
        var justSavedWorker = this.workersService.saveNew(WorkersMapper.toEntity(workerDto));
        var location = URI.create(host.concat("/workers/".concat(justSavedWorker.getId().toString())));
        return ResponseEntity.created(location).body(WorkersMapper.toDto(justSavedWorker));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateWorker(@PathVariable Long id, @RequestBody WorkerDto workerDto){
        workerDto.setId(id);
        this.workersService.save(WorkersMapper.toEntity(workerDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id){
        this.workersService.deleteBy(id);
        return ResponseEntity.noContent().build();
    }

}
