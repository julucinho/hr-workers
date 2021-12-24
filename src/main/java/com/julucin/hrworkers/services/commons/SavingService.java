package com.julucin.hrworkers.services.commons;

public interface SavingService<E> {

    E saveNew(E newEntity);
    void save(E entity);

}
