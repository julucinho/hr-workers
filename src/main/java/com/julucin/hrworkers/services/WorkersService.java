package com.julucin.hrworkers.services;

import com.julucin.hrworkers.entities.WorkerEntity;
import com.julucin.hrworkers.services.common.DeletingService;
import com.julucin.hrworkers.services.common.RetrievingService;
import com.julucin.hrworkers.services.common.SavingService;
import org.springframework.stereotype.Service;

@Service
public interface WorkersService extends SavingService<WorkerEntity>,
        RetrievingService<WorkerEntity, Long>,
        DeletingService<Long> {
}
