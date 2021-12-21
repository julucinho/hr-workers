package com.julucin.hrworkers.exceptions.thrower;

import com.julucin.hrworkers.exceptions.InstanceDoesNotExistException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class WorkerExceptionsThrower {

    public static void throwInstanceDoesNotExistException(Long id){
        var message = "There isn't an instance of worker with ID ".concat(id.toString());
        log.info(message);
        throw new InstanceDoesNotExistException(message);
    }

}
