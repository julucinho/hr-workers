package com.julucin.hrworkers.exceptions.factories;

import com.julucin.hrworkers.exceptions.InstanceDoesNotExistException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class WorkerExceptionsFactory {

    public InstanceDoesNotExistException makeInstanceDoesNotExistException(Long id){
        var message = "There isn't an instance of worker with ID ".concat(id.toString());
        log.info(message);
        return new InstanceDoesNotExistException(message);
    }

}
