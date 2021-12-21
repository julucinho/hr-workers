package com.julucin.hrworkers.services.common;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RetrievingService<E, I> {

    List<E> retrieveAll();
    Page<E> retrievePageOf(Integer pageNumber, Integer pageSize);
    Optional<E> retrieveBy(I id);

}
