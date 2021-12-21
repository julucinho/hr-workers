package com.julucin.hrworkers.exceptions.throwers;

import com.julucin.hrworkers.exceptions.factories.WorkerExceptionsFactory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkerExceptionsThrower {

    public static void throwInstanceDoesNotExistException(Long id){
        throw WorkerExceptionsFactory.makeInstanceDoesNotExistException(id);
    }

}
