package com.julucin.hrworkers.repositories;

import com.julucin.hrworkers.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<WorkerEntity, Long> {
}
