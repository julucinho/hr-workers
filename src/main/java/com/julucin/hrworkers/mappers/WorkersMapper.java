package com.julucin.hrworkers.mappers;

import com.julucin.hrworkers.dtos.WorkerDto;
import com.julucin.hrworkers.entities.WorkerEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkersMapper {

    private static final Class<WorkerEntity> WORKER_ENTITY_CLASS = WorkerEntity.class;
    private static final Class<WorkerDto> WORKER_DTO_CLASS = WorkerDto.class;

    public WorkerEntity toEntity(WorkerDto dto){
        return Mapper.map(dto).to(WORKER_ENTITY_CLASS);
    }

    public WorkerDto toDto(WorkerEntity dto){
        return Mapper.map(dto).to(WORKER_DTO_CLASS);
    }

}
