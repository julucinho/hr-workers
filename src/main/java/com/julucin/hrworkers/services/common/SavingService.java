package com.julucin.hrworkers.services.common;

public interface SavingService<E> {

    E saveNew(E newEntity);
    void save(E entity);

}
